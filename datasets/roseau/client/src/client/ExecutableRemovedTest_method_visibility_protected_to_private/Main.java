package client.ExecutableRemovedTest_method_visibility_protected_to_private;

import ExecutableRemovedTest_method_visibility_protected_to_private.*;

public class Main {
    public static void main(String[] args) {
        new A() {
			@Override protected void m1() {
				super.m1();
			}
		}.m1();
    }
}
