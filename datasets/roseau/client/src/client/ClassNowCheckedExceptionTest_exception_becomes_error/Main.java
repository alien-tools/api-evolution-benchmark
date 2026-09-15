package client.ClassNowCheckedExceptionTest_exception_becomes_error;

import ClassNowCheckedExceptionTest_exception_becomes_error.*;

public class Main {
    public static void main(String[] args) {
        class X {
			Exception make() {
				return new A();
			}
		}
		new X().make();
    }
}
