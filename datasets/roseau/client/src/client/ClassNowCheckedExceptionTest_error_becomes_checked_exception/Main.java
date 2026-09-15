package client.ClassNowCheckedExceptionTest_error_becomes_checked_exception;

import ClassNowCheckedExceptionTest_error_becomes_checked_exception.*;

public class Main {
    public static void main(String[] args) {
        class X {
			Error make() {
				return new A();
			}
		}
		new X().make();
    }
}
