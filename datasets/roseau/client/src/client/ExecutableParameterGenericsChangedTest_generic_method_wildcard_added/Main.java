package client.ExecutableParameterGenericsChangedTest_generic_method_wildcard_added;

import ExecutableParameterGenericsChangedTest_generic_method_wildcard_added.*;

public class Main {
    public static void main(String[] args) {
        new A().<Number>m(java.util.List.<Number>of());
		new A() {
			@Override public <T> void m(java.util.List<T> l) {}
		}.m(java.util.List.<Number>of());
    }
}
