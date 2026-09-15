package client.ExecutableParameterGenericsChangedTest_generic_method_wildcard_removed;

import ExecutableParameterGenericsChangedTest_generic_method_wildcard_removed.*;

public class Main {
    public static void main(String[] args) {
        new A().<Number>m(java.util.List.<Integer>of());
    }
}
