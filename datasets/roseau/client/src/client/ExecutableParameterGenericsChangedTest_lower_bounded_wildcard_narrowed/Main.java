package client.ExecutableParameterGenericsChangedTest_lower_bounded_wildcard_narrowed;

import ExecutableParameterGenericsChangedTest_lower_bounded_wildcard_narrowed.*;

public class Main {
    public static void main(String[] args) {
        new A().m(new java.util.ArrayList<Number>());
		new A() {
			@Override public void m(java.util.List<? super Number> l) {}
		}.m(java.util.List.<Number>of());
    }
}
