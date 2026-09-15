package client.ClassNoLongerConcretelyExtensibleTest_abstract_method_no_longer_overridden;

import ClassNoLongerConcretelyExtensibleTest_abstract_method_no_longer_overridden.*;

public class Main {
    public static void main(String[] args) {
        class C extends B {
			@Override public void m() {}
			@Override public void n() {}
		}
    }
}
