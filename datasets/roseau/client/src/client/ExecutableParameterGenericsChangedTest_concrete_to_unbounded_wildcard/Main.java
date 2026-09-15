package client.ExecutableParameterGenericsChangedTest_concrete_to_unbounded_wildcard;

import ExecutableParameterGenericsChangedTest_concrete_to_unbounded_wildcard.*;

public class Main {
    public static void main(String[] args) {
        new A().m(java.util.List.<String>of());
		new A() {
			@Override public void m(java.util.List<String> l) {}
		}.m(java.util.List.<String>of());
    }
}
