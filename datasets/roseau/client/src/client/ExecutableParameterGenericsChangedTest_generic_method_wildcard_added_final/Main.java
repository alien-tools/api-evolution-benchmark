package client.ExecutableParameterGenericsChangedTest_generic_method_wildcard_added_final;

import ExecutableParameterGenericsChangedTest_generic_method_wildcard_added_final.*;

public class Main {
    public static void main(String[] args) {
        new A().<Number>m(java.util.List.<Number>of());
    }
}
