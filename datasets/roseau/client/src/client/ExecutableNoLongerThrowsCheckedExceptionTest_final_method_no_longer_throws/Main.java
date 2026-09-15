package client.ExecutableNoLongerThrowsCheckedExceptionTest_final_method_no_longer_throws;

import ExecutableNoLongerThrowsCheckedExceptionTest_final_method_no_longer_throws.*;

public class Main {
    public static void main(String[] args) {
        try {
			new A().m();
		} catch (java.io.IOException e) {}
    }
}
