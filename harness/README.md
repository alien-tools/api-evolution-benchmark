# Benchmark harness

Builds the ground truth for each dataset and runs the detection tools against it.

```bash
mvn -DskipTests package
mvn exec:java                     # every tool on every dataset
mvn exec:java -Dexec.args=jezek   # a single dataset
```

## Requirements

- **JDK 25.** `JavaCompiler.ensureJavaVersion(25)` aborts the run on any other version: the ground
  truth is only meaningful if every case is compiled and linked by one known compiler.
- Tool versions are the `roseau.version`, `japicmp.version`, and `revapi-java.version` properties
  in `pom.xml`. All three come from Maven Central.

## Adding a dataset

Drop it under `datasets/<name>/` and add one constant to `Dataset`:

```java
public static final Dataset MY_DATASET = new Dataset("my-dataset",
    path("my-dataset/v1/src"),
    path("my-dataset/v2/src"),
    path("my-dataset/client/src"));
```

## Adding a tool

Extend `Tool`, returning a `BreakingVerdict` from `analyze(v1Jar, v2Jar)`, and add an instance to
`TOOLS` in `AccuracyBenchmark`. The CSV columns follow automatically.
