package com.github.alien.bench;

import java.io.UncheckedIOException;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;

/**
 * A benchmark dataset: a set of cases, each made of a baseline API, an updated API, and a client
 * exercising the baseline.
 *
 * <p>Case directories are the direct children of {@link #v1Sources()}, {@link #v2Sources()} and
 * {@link #clientSources()}, and are matched across the three by name. A case may be missing from
 * either API version (an API that only exists before or after the change); the benchmark then
 * substitutes an empty JAR.
 *
 * <p>Datasets differ only in where those three directories sit under {@code datasets/<name>}: the
 * intermediate directories are the Java packages the sources declare.
 */
public record Dataset(String name, Path v1Sources, Path v2Sources, Path clientSources) {
	public static final Dataset JEZEK = new Dataset("jezek",
		path("jezek/v1/src/testing_lib"),
		path("jezek/v2/src/testing_lib"),
		path("jezek/client/src"));

	public static final Dataset ROSEAU = new Dataset("roseau",
		path("roseau/v1/src"),
		path("roseau/v2/src"),
		path("roseau/client/src/client"));

	public static final List<Dataset> ALL = List.of(JEZEK, ROSEAU);

	public static Dataset byName(String name) {
		return ALL.stream()
			.filter(dataset -> dataset.name().equalsIgnoreCase(name))
			.findFirst()
			.orElseThrow(() -> new IllegalArgumentException("Unknown dataset '%s'; expected one of %s"
				.formatted(name, ALL.stream().map(Dataset::name).toList())));
	}

	public int size() {
		try (var cases = Files.list(clientSources)) {
			return (int) cases.filter(Files::isDirectory).count();
		} catch (IOException e) {
			throw new UncheckedIOException("Couldn't list cases of dataset " + name, e);
		}
	}

	private static Path path(String relativePath) {
		return repositoryRoot().resolve("datasets").resolve(relativePath);
	}

	/**
	 * Locates the repository root by walking up from the working directory in search of
	 * {@code datasets/}, so that the benchmark behaves identically whether it is run from the
	 * repository root or from {@code harness/}.
	 */
	public static Path repositoryRoot() {
		var directory = Path.of("").toAbsolutePath();
		while (directory != null) {
			if (Files.isDirectory(directory.resolve("datasets"))) {
				return directory;
			}
			directory = directory.getParent();
		}
		throw new IllegalStateException("Couldn't find a datasets/ directory in %s or any of its parents"
			.formatted(Path.of("").toAbsolutePath()));
	}
}
