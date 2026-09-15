package client.ExecutableNoLongerThrowsCheckedExceptionTest_static_method_no_longer_throws;

import ExecutableNoLongerThrowsCheckedExceptionTest_static_method_no_longer_throws.*;

public class Main {
    public static void main(String[] args) {
        try {
			A.m();
		} catch (java.io.IOException e) {}
    }
}
