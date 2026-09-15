package client.ExecutableNowThrowsCheckedExceptionTest_method_now_throws_subtype;

import ExecutableNowThrowsCheckedExceptionTest_method_now_throws_subtype.*;

public class Main {
    public static void main(String[] args) {
        new A() {
			@Override public void m() throws java.io.IOException {}
		};
    }
}
