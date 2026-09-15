package client.ExecutableRemovedTest_protected_to_package_private;

import ExecutableRemovedTest_protected_to_package_private.*;

public class Main {
    public static void main(String[] args) {
        new A() {
			@Override protected void m() {
				super.m();
			}
		}.m();
    }
}
