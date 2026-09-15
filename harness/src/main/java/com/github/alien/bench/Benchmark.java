package com.github.alien.bench;

import com.github.alien.compiler.JavaCompiler;
import com.github.alien.tool.BreakingVerdict;
import com.github.alien.tool.Tool;
import com.google.common.io.MoreFiles;

import java.io.IOException;
import java.io.UncheckedIOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.StandardOpenOption;
import java.util.Comparator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import java.util.function.Consumer;
import java.util.jar.JarOutputStream;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * Runs a set of {@link Tool}s over a {@link Dataset} and reports how their verdicts compare to the
 * ground truth established by the Java compiler and linker.
 */
public class Benchmark {
	private static final String CASES_CSV = "results-by-case.csv";
	private static final String TOOLS_CSV = "results-by-tool.csv";
	private static final String GROUND_TRUTH = "GroundTruth";
	private static final int JAVA_VERSION = 25;

	private final Dataset dataset;
	private final List<Tool> tools;
	private final Path workingDir;
	private final Path casesCsv;
	private final Path toolsCsv;
	/** Cases whose own sources don't compile, and which therefore can't be part of the ground truth. */
	private final Set<String> invalidCases = ConcurrentHashMap.newKeySet();

	/**
	 * @param workingDir where the compiled case JARs go; wiped at the start of every run
	 * @param resultsDir where the two result CSVs go; preserved across runs so that an interrupted
	 *                   run resumes where it stopped
	 */
	public Benchmark(Dataset dataset, List<Tool> tools, Path workingDir, Path resultsDir) {
		this.dataset = dataset;
		this.tools = tools;
		this.workingDir = workingDir;
		this.casesCsv = resultsDir.resolve(CASES_CSV);
		this.toolsCsv = resultsDir.resolve(TOOLS_CSV);
	}

	public void run() throws IOException {
		JavaCompiler.ensureJavaVersion(JAVA_VERSION);

		System.out.printf("%n=== %s (%d cases) ===%n", dataset.name(), dataset.size());
		if (Files.isDirectory(workingDir)) {
			MoreFiles.deleteRecursively(workingDir);
		}
		Files.createDirectories(workingDir);
		Files.createDirectories(casesCsv.getParent());

		var v1Jars = workingDir.resolve("v1");
		var v2Jars = workingDir.resolve("v2");
		var clientJars = workingDir.resolve("client");

		packageLibraryCases(dataset.v1Sources(), v1Jars);
		packageLibraryCases(dataset.v2Sources(), v2Jars);
		packageClientCases(dataset.clientSources(), v1Jars, clientJars);

		var groundTruth = buildGroundTruth(dataset.clientSources(), clientJars, v2Jars);
		benchmarkTools(groundTruth, v1Jars, v2Jars);
		writeToolSummaries();

		if (!invalidCases.isEmpty()) {
			System.out.printf("%nWARNING: excluded %d case(s) of %s that do not compile: %s%n",
				invalidCases.size(), dataset.name(), invalidCases.stream().sorted().toList());
		}

		System.out.printf("%n%s results:%n%s%n", dataset.name(), Files.readString(toolsCsv));
	}

	private void packageLibraryCases(Path sourcesPath, Path jarsPath) {
		System.out.printf("Packaging %s to %s...%n", sourcesPath, jarsPath);

		forEachCase(sourcesPath, caseDir -> {
			var caseName = caseDir.getFileName();
			var classesPath = jarsPath.resolve("%s-classes".formatted(caseName));
			var jarPath = jarsPath.resolve("%s.jar".formatted(caseName));

			try {
				JavaCompiler.packageSources(caseDir, classesPath, jarPath, List.of(), true);
				MoreFiles.deleteRecursively(classesPath);
			} catch (Exception e) {
				reportInvalidCase(caseName.toString(), "library sources don't compile", e);
			}
		});
	}

	private void packageClientCases(Path clientPath, Path v1JarsPath, Path clientJarPath) {
		System.out.printf("Packaging %s against %s...%n", clientPath, v1JarsPath);

		forEachCase(clientPath, caseDir -> {
			var caseName = caseDir.getFileName().toString();
			var clientClasses = clientJarPath.resolve("%s-classes".formatted(caseName));
			var clientJar = clientJarPath.resolve("%s.jar".formatted(caseName));
			var v1Jar = v1JarsPath.resolve("%s.jar".formatted(caseName));
			if (invalidCases.contains(caseName)) {
				return;
			}

			try {
				ensureJarExists(v1Jar);
				JavaCompiler.packageSources(caseDir, clientClasses, clientJar, List.of(v1Jar), true);
				MoreFiles.deleteRecursively(clientClasses);
			} catch (Exception e) {
				reportInvalidCase(caseName, "client doesn't compile against v1", e);
			}
		});
	}

	/**
	 * Establishes, for every case, whether moving the client from v1 to v2 breaks compilation
	 * (source-incompatible) or linking (binary-incompatible).
	 */
	private Map<String, BreakingVerdict> buildGroundTruth(Path clientsPath, Path clientJarsPath, Path v2JarsPath) {
		System.out.println("Building ground truth...");

		Map<String, BreakingVerdict> groundTruth = new ConcurrentHashMap<>();
		forEachCase(clientsPath, caseDir -> {
			var caseName = caseDir.getFileName();
			if (invalidCases.contains(caseName.toString())) {
				return;
			}
			var clientClasses = clientJarsPath.resolve("%s-classes".formatted(caseName));
			var clientJar = clientJarsPath.resolve("%s.jar".formatted(caseName));
			var v2Jar = v2JarsPath.resolve("%s.jar".formatted(caseName));
			var message = new StringBuilder();
			ensureJarExists(v2Jar);

			// Recompile the client against v2
			var compilationMessage = JavaCompiler.compileSources(caseDir, clientClasses, List.of(v2Jar), false);
			var isSourceBreaking = compilationMessage != null;
			if (isSourceBreaking) {
				message.append("Compiler: ").append(compilationMessage);
			}

			// Relink the client against v2
			var linkingMessage = JavaCompiler.linkAgainstJar(clientJar, v2Jar, resolveMainClass(caseDir));
			var isBinaryBreaking = linkingMessage != null;
			if (isBinaryBreaking) {
				message.append("Linker: ").append(linkingMessage);
			}

			groundTruth.put(caseName.toString(), new BreakingVerdict(isBinaryBreaking, isSourceBreaking,
				message.toString()));

			if (Files.isDirectory(clientClasses)) {
				try {
					MoreFiles.deleteRecursively(clientClasses);
				} catch (IOException e) {
					throw new UncheckedIOException(e);
				}
			}
		});

		return groundTruth;
	}

	/**
	 * A case whose own sources don't compile has no meaningful ground truth: report it and leave it
	 * out of the run rather than failing the whole dataset.
	 */
	private void reportInvalidCase(String caseName, String reason, Exception cause) {
		invalidCases.add(caseName);
		System.err.printf("Excluding case %s of %s: %s (%s)%n", caseName, dataset.name(), reason,
			cause.getMessage());
	}

	private static String resolveMainClass(Path caseDir) {
		var mainJava = caseDir.resolve("Main.java");
		if (!Files.exists(mainJava)) {
			throw new RuntimeException("Missing Main.java in client case " + caseDir);
		}

		try {
			return Files.readString(mainJava).lines()
				.map(String::trim)
				.filter(line -> line.startsWith("package ") && line.endsWith(";"))
				.map(line -> line.substring("package ".length(), line.length() - 1).trim())
				.filter(packageName -> !packageName.isEmpty())
				.findFirst()
				.map(packageName -> packageName + ".Main")
				.orElse("Main");
		} catch (IOException e) {
			throw new UncheckedIOException("Unable to resolve main class for client case " + caseDir, e);
		}
	}

	private void benchmarkTools(Map<String, BreakingVerdict> groundTruth, Path v1JarsPath, Path v2JarsPath) {
		System.out.printf("Benchmarking %s...%n", tools.stream().map(Tool::getName).collect(Collectors.joining(", ")));
		prepareCasesCsv();
		var completedCases = completedCases();

		groundTruth.entrySet().stream()
			.filter(entry -> !completedCases.contains(entry.getKey()))
			.sorted(Map.Entry.comparingByKey())
			.parallel()
			.forEach(entry -> {
				var caseName = entry.getKey();
				var expected = entry.getValue();
				var v1Jar = v1JarsPath.resolve("%s.jar".formatted(caseName));
				var v2Jar = v2JarsPath.resolve("%s.jar".formatted(caseName));
				ensureJarExists(v1Jar);
				ensureJarExists(v2Jar);

				var verdicts = new ConcurrentHashMap<String, BreakingVerdict>();
				tools.parallelStream().forEach(tool -> {
					var verdict = tool.analyze(v1Jar, v2Jar);
					System.out.printf("[%s] %s [bin: %b, src: %b]%n", tool.getName(), caseName,
						verdict.isBinaryBreaking(), verdict.isSourceBreaking());
					verdicts.put(tool.getName(), verdict);
				});

				appendCase(caseName, expected, verdicts);
			});
	}

	private void appendCase(String caseName, BreakingVerdict expected, Map<String, BreakingVerdict> verdicts) {
		var line = new StringBuilder(caseName);
		line.append(";%b;%b;%s".formatted(expected.isBinaryBreaking(), expected.isSourceBreaking(),
			csvField(expected.message())));
		tools.forEach(tool -> {
			var verdict = verdicts.get(tool.getName());
			line.append(";%b;%b;%b;%b;%s".formatted(
				verdict.isBinaryBreaking(),
				verdict.isSourceBreaking(),
				verdict.isBinaryBreaking() == expected.isBinaryBreaking(),
				verdict.isSourceBreaking() == expected.isSourceBreaking(),
				csvField(verdict.message())));
		});

		try {
			Files.writeString(casesCsv, line + "\n", StandardOpenOption.APPEND);
		} catch (IOException e) {
			throw new UncheckedIOException("Unable to append case %s to %s".formatted(caseName, casesCsv), e);
		}
	}

	private static String csvField(String value) {
		return value.replace(';', ',').replace('\r', ' ').replace('\n', ' ');
	}

	private void prepareCasesCsv() {
		try {
			if (Files.notExists(casesCsv)) {
				var header = "case;" + GROUND_TRUTH + "_bin;" + GROUND_TRUTH + "_src;" + GROUND_TRUTH + "_message;" +
					tools.stream()
						.map(tool -> "%1$s_bin;%1$s_src;correct_%1$s_bin;correct_%1$s_src;%1$s_message"
							.formatted(tool.getName()))
						.collect(Collectors.joining(";"));
				Files.writeString(casesCsv, header + "\n");
			} else {
				removeIncompleteLastLine();
			}
		} catch (IOException e) {
			throw new UncheckedIOException("Unable to initialize results CSV " + casesCsv, e);
		}
	}

	/** A run interrupted mid-write leaves a truncated line behind; drop it before resuming. */
	private void removeIncompleteLastLine() throws IOException {
		var lines = Files.readAllLines(casesCsv);
		if (lines.size() < 2) {
			return;
		}

		var expectedFieldCount = lines.getFirst().split(";", -1).length;
		var lastLine = lines.getLast().trim();
		if (lastLine.isEmpty() || lastLine.split(";", -1).length != expectedFieldCount) {
			lines.removeLast();
			Files.writeString(casesCsv, String.join("\n", lines) + "\n");
		}
	}

	private Set<String> completedCases() {
		try (var lines = csvRows()) {
			return lines.map(row -> row[0]).collect(Collectors.toSet());
		}
	}

	/** Reads back the case CSV, so that summaries cover resumed runs too, not just this session. */
	private Stream<String[]> csvRows() {
		if (Files.notExists(casesCsv)) {
			return Stream.empty();
		}

		try {
			return Files.readAllLines(casesCsv).stream()
				.map(String::trim)
				.filter(line -> !line.isEmpty() && !line.startsWith("case;"))
				.map(line -> line.split(";", -1));
		} catch (IOException e) {
			throw new UncheckedIOException("Unable to read " + casesCsv, e);
		}
	}

	private void writeToolSummaries() {
		var metricsByTool = new LinkedHashMap<String, ToolMetrics>();
		tools.forEach(tool -> metricsByTool.put(tool.getName(), new ToolMetrics()));

		// case;gt_bin;gt_src;gt_message, then 5 columns per tool
		csvRows().forEach(row -> {
			var expected = new BreakingVerdict(Boolean.parseBoolean(row[1]), Boolean.parseBoolean(row[2]), "");
			for (var i = 0; i < tools.size(); i++) {
				var offset = 4 + i * 5;
				var verdict = new BreakingVerdict(Boolean.parseBoolean(row[offset]),
					Boolean.parseBoolean(row[offset + 1]), "");
				metricsByTool.get(tools.get(i).getName()).update(expected, verdict);
			}
		});

		var csv = new StringBuilder("tool;scope;tp;fp;fn;precision;recall;f1\n");
		metricsByTool.forEach((toolName, metrics) -> {
			csv.append(metrics.breaking.toCsvRow(toolName, "breaking"));
			csv.append(metrics.source.toCsvRow(toolName, "source"));
			csv.append(metrics.binary.toCsvRow(toolName, "binary"));
		});

		try {
			Files.writeString(toolsCsv, csv.toString());
		} catch (IOException e) {
			throw new UncheckedIOException("Unable to write " + toolsCsv, e);
		}
	}

	/** Runs {@code action} over every case directory of {@code casesPath}, in parallel. */
	private static void forEachCase(Path casesPath, Consumer<Path> action) {
		try (var cases = Files.list(casesPath)) {
			cases.filter(Files::isDirectory)
				.sorted(Comparator.comparing(Path::getFileName))
				.parallel()
				.forEach(action);
		} catch (IOException e) {
			throw new UncheckedIOException("Couldn't list cases from %s".formatted(casesPath), e);
		}
	}

	/** Cases missing from one API version are compared against an empty, but valid, JAR. */
	private static void ensureJarExists(Path jarPath) {
		if (Files.exists(jarPath)) {
			return;
		}

		try {
			Files.createDirectories(jarPath.getParent());
			try (var ignored = new JarOutputStream(Files.newOutputStream(jarPath))) {
				// Empty but valid JAR archive.
			}
		} catch (IOException e) {
			throw new UncheckedIOException("Unable to create empty JAR at " + jarPath, e);
		}
	}

	private static final class ToolMetrics {
		private final MetricsCounts breaking = new MetricsCounts();
		private final MetricsCounts source = new MetricsCounts();
		private final MetricsCounts binary = new MetricsCounts();

		private void update(BreakingVerdict expected, BreakingVerdict predicted) {
			breaking.update(predicted.isBreaking(), expected.isBreaking());
			source.update(predicted.isSourceBreaking(), expected.isSourceBreaking());
			binary.update(predicted.isBinaryBreaking(), expected.isBinaryBreaking());
		}
	}

	private static final class MetricsCounts {
		private int tp;
		private int fp;
		private int fn;

		private void update(boolean predictedPositive, boolean actualPositive) {
			if (predictedPositive && actualPositive) {
				tp++;
			} else if (predictedPositive) {
				fp++;
			} else if (actualPositive) {
				fn++;
			}
		}

		private double precision() {
			return tp + fp == 0 ? 0.0 : (double) tp / (tp + fp);
		}

		private double recall() {
			return tp + fn == 0 ? 0.0 : (double) tp / (tp + fn);
		}

		private double f1() {
			var p = precision();
			var r = recall();
			return p + r == 0.0 ? 0.0 : 2.0 * p * r / (p + r);
		}

		private String toCsvRow(String toolName, String scope) {
			// Locale.ROOT: the CSV must use '.' as the decimal separator whatever the default locale is
			return String.format(Locale.ROOT, "%s;%s;%d;%d;%d;%.4f;%.4f;%.4f%n", toolName, scope, tp, fp, fn,
				precision(), recall(), f1());
		}
	}
}
