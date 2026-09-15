# API evolution benchmark

Measures how accurately Java breaking-change detection tools identify source- and
binary-incompatible API changes, using a Java 25 compiler/linker-derived ground truth.

## Evaluated tools


  - [Roseau 0.7.0](https://github.com/alien-tools/roseau)
  - [japicmp 0.26.2](https://siom79.github.io/japicmp/)
  - [Revapi 0.28.4](https://revapi.org).

## Datasets

  - Jezek (310 cases): presented in [API Evolution and Compatibility: A Data Corpus and Tool Evaluation](https://www.jot.fm/issues/issue_2017_04/article2.pdf) by Jezek and Dietrich. Manually fixed some buggy cases and significantly strengthened the clients to address false negatives.
  - Roseau (423 cases): the cases are automatically extracted from [Roseau's test suite](https://github.com/alien-tools/roseau/tree/main/core/src/test/java/io/github/alien/roseau/diff)

## How it works

Each case consists of a baseline API (`v1`), an updated version of that API with a single change introduced (`v2`), and a client with a `main()` method that uses baseline symbols.

The ground truth is derived automatically:

  1. `v1` and `v2` are each compiled and packaged into a JAR.
  2. The client is compiled and packaged against `v1`.
  3. The client sources are recompiled against `v2` — a compiler error marks the case source-incompatible.
  4. The client JAR is executed against `v2` — a linkage error marks the case binary-incompatible.

Each tool is then given only the two API JARs (never the client) and must report whether the change is source- and/or binary-breaking. Verdicts are compared per case against the ground truth to produce precision, recall, and F1.

## Running it

Requires **JDK 25** and Maven 3.9+.

```bash
cd harness && mvn -DskipTests package && mvn exec:java
```

This benchmarks every tool on every dataset. To run a single one, name it:

```bash
mvn exec:java -Dexec.args=jezek
```

Each dataset writes two CSVs to `results/<dataset>/`:

- `results-by-case.csv` — one row per case: the ground truth, each tool's verdict, and whether it was correct.
- `results-by-tool.csv` — precision/recall/F1 per tool, for the `breaking`, `source`, and `binary` scopes.

## Caveats

- Only **syntactic** (source/binary) compatibility is evaluated; behavioral and semantic changes are out of scope.
- A case flagged as breaking is definitely breaking. The converse is weaker: a case may be non-breaking only because the corpus lacks a client that would have exposed the break.
- The library and the client live in different packages, so the benchmark treats package-private symbols as outside the API.
- The benchmark evaluates whether the tools identify *some* breaking changes with the right compatibility level (source or binary). However, it does not evaluate whether the breaking change kind reported by the tools (e.g., `CLASS_NOW_FINAL`) indeed corresponds to the case.

### Results

<table>
  <thead>
    <tr>
      <th>Dataset</th>
      <th>Category</th>
      <th>Metric</th>
      <th>Roseau</th>
      <th>japicmp</th>
      <th>Revapi</th>
    </tr>
  </thead>
  <tbody>
    <tr>
      <td rowspan="9">Jezek (310 cases)</td>
      <td rowspan="3">Breaking</td>
      <td>Precision</td>
      <td><strong>0.98</strong></td>
      <td>0.89</td>
      <td>0.82</td>
    </tr>
    <tr>
      <td>Recall</td>
      <td><strong>1.00</strong></td>
      <td>0.83</td>
      <td>0.97</td>
    </tr>
    <tr>
      <td>F1</td>
      <td><strong>0.99</strong></td>
      <td>0.86</td>
      <td>0.89</td>
    </tr>
    <tr>
      <td rowspan="3">Source</td>
      <td>Precision</td>
      <td><strong>0.90</strong></td>
      <td>0.78</td>
      <td>0.74</td>
    </tr>
    <tr>
      <td>Recall</td>
      <td><strong>1.00</strong></td>
      <td>0.81</td>
      <td>0.96</td>
    </tr>
    <tr>
      <td>F1</td>
      <td><strong>0.95</strong></td>
      <td>0.80</td>
      <td>0.84</td>
    </tr>
    <tr>
      <td rowspan="3">Binary</td>
      <td>Precision</td>
      <td><strong>0.95</strong></td>
      <td>0.91</td>
      <td>0.92</td>
    </tr>
    <tr>
      <td>Recall</td>
      <td><strong>1.00</strong></td>
      <td><strong>1.00</strong></td>
      <td>0.97</td>
    </tr>
    <tr>
      <td>F1</td>
      <td><strong>0.98</strong></td>
      <td>0.95</td>
      <td>0.94</td>
    </tr>
    <tr>
      <td rowspan="9">Roseau (423 cases)</td>
      <td rowspan="3">Breaking</td>
      <td>Precision</td>
      <td><strong>0.99</strong></td>
      <td>0.70</td>
      <td>0.75</td>
    </tr>
    <tr>
      <td>Recall</td>
      <td><strong>0.99</strong></td>
      <td>0.85</td>
      <td>0.91</td>
    </tr>
    <tr>
      <td>F1</td>
      <td><strong>0.99</strong></td>
      <td>0.77</td>
      <td>0.82</td>
    </tr>
    <tr>
      <td rowspan="3">Source</td>
      <td>Precision</td>
      <td><strong>0.99</strong></td>
      <td>0.65</td>
      <td>0.71</td>
    </tr>
    <tr>
      <td>Recall</td>
      <td><strong>0.99</strong></td>
      <td>0.84</td>
      <td>0.89</td>
    </tr>
    <tr>
      <td>F1</td>
      <td><strong>0.99</strong></td>
      <td>0.73</td>
      <td>0.79</td>
    </tr>
    <tr>
      <td rowspan="3">Binary</td>
      <td>Precision</td>
      <td><strong>0.84</strong></td>
      <td>0.75</td>
      <td>0.70</td>
    </tr>
    <tr>
      <td>Recall</td>
      <td><strong>1.00</strong></td>
      <td>0.98</td>
      <td>0.95</td>
    </tr>
    <tr>
      <td>F1</td>
      <td><strong>0.91</strong></td>
      <td>0.85</td>
      <td>0.80</td>
    </tr>
  </tbody>
</table>
