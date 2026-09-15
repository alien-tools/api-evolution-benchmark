package client.ExecutableNoLongerThrowsCheckedExceptionTest_method_throws_another_checked;

import ExecutableNoLongerThrowsCheckedExceptionTest_method_throws_another_checked.*;

public class Main {
    public static void main(String[] args) {
        try {
			new A().m();
		} catch (java.io.IOException e) {}
    }
}
