package client.ExecutableNoLongerThrowsCheckedExceptionTest_interface_default_method_no_longer_throws;

import ExecutableNoLongerThrowsCheckedExceptionTest_interface_default_method_no_longer_throws.*;

public class Main {
    public static void main(String[] args) {
        try {
			A a = new A() {};
			a.m();
		} catch (java.io.IOException e) {}
    }
}
