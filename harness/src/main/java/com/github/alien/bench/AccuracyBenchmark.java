package com.github.alien.bench;

import com.github.alien.tool.JapicmpTool;
import com.github.alien.tool.RevapiTool;
import com.github.alien.tool.RoseauTool;
import com.github.alien.tool.Tool;

import java.nio.file.Path;
import java.util.Arrays;
import java.util.List;

/**
 * Entry point: runs every tool over every dataset.
 *
 * <p>Without arguments, all datasets are benchmarked. Otherwise, only the named ones are:
 * {@code mvn exec:java -Dexec.args=jezek}.
 */
public class AccuracyBenchmark {
	private static final List<Tool> TOOLS = List.of(
		new RoseauTool(),
		new JapicmpTool(),
		new RevapiTool()
	);

	private static final Path WORKING_DIR = Dataset.repositoryRoot().resolve("working-dir");
	private static final Path RESULTS_DIR = Dataset.repositoryRoot().resolve("results");

	public static void main(String[] args) throws Exception {
		var datasets = args.length == 0
			? Dataset.ALL
			: Arrays.stream(args).map(Dataset::byName).toList();

		for (var dataset : datasets) {
			new Benchmark(dataset, TOOLS,
				WORKING_DIR.resolve(dataset.name()),
				RESULTS_DIR.resolve(dataset.name()))
				.run();
		}
	}
}
