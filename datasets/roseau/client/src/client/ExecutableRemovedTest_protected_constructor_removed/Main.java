package client.ExecutableRemovedTest_protected_constructor_removed;

import ExecutableRemovedTest_protected_constructor_removed.*;

public class Main {
    public static void main(String[] args) {
        class B extends A {
			B(int i) {
				super(i);
			}
		};
		new B(0);
    }
}
