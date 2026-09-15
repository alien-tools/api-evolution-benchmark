package client.ExecutableParameterGenericsChangedTest_lower_bounded_wildcard_widened;

import ExecutableParameterGenericsChangedTest_lower_bounded_wildcard_widened.*;

public class Main {
    public static void main(String[] args) {
        new A().m(java.util.List.<Integer>of());
    }
}
