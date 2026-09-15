package client.ExecutableNoLongerThrowsCheckedExceptionTest_method_no_longer_throws_throwable;

import ExecutableNoLongerThrowsCheckedExceptionTest_method_no_longer_throws_throwable.*;

public class Main {
    public static void main(String[] args) {
        try {
			new A().m();
		} catch (Throwable e) {}
		new A() {
			@Override public void m() throws Throwable {}
		};
    }
}
