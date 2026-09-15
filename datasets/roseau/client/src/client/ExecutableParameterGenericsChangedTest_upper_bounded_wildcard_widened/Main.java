package client.ExecutableParameterGenericsChangedTest_upper_bounded_wildcard_widened;

import ExecutableParameterGenericsChangedTest_upper_bounded_wildcard_widened.*;

public class Main {
    public static void main(String[] args) {
        new A().m(java.util.List.<Integer>of());
		new A() {
			@Override public void m(java.util.List<? extends Integer> l) {}
		}.m(java.util.List.<Integer>of());
    }
}
