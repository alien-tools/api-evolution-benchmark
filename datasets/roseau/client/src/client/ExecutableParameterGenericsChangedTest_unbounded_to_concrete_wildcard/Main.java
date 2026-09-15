package client.ExecutableParameterGenericsChangedTest_unbounded_to_concrete_wildcard;

import ExecutableParameterGenericsChangedTest_unbounded_to_concrete_wildcard.*;

public class Main {
    public static void main(String[] args) {
        new A().m(java.util.List.<Integer>of());
    }
}
