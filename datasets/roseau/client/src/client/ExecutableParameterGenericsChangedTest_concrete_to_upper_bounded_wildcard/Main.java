package client.ExecutableParameterGenericsChangedTest_concrete_to_upper_bounded_wildcard;

import ExecutableParameterGenericsChangedTest_concrete_to_upper_bounded_wildcard.*;

public class Main {
    public static void main(String[] args) {
        new A().m(java.util.List.<Integer>of());
		new A() {
			@Override public void m(java.util.List<Integer> l) {}
		}.m(java.util.List.<Integer>of());
    }
}
