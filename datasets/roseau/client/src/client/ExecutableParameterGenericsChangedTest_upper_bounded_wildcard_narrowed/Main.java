package client.ExecutableParameterGenericsChangedTest_upper_bounded_wildcard_narrowed;

import ExecutableParameterGenericsChangedTest_upper_bounded_wildcard_narrowed.*;

public class Main {
    public static void main(String[] args) {
        new A().m(java.util.List.<Number>of());
    }
}
