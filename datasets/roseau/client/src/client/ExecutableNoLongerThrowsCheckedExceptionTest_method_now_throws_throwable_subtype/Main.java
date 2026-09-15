package client.ExecutableNoLongerThrowsCheckedExceptionTest_method_now_throws_throwable_subtype;

import ExecutableNoLongerThrowsCheckedExceptionTest_method_now_throws_throwable_subtype.*;

public class Main {
    public static void main(String[] args) {
        new A() {
			@Override public void m() throws Throwable {}
		};
    }
}
