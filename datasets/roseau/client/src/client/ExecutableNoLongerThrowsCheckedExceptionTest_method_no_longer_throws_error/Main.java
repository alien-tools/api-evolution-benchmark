package client.ExecutableNoLongerThrowsCheckedExceptionTest_method_no_longer_throws_error;

import ExecutableNoLongerThrowsCheckedExceptionTest_method_no_longer_throws_error.*;

public class Main {
    public static void main(String[] args) {
        try {
			new A().m();
		} catch (OutOfMemoryError e) {}
    }
}
