package client.ExecutableRemovedTest_leaked_protected_method_now_private;

import ExecutableRemovedTest_leaked_protected_method_now_private.*;

public class Main {
    public static void main(String[] args) {
        new B() {
			@Override protected void m() {
				super.m();
			}
		}.m();
    }
}
