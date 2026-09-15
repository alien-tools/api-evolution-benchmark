package client.ClassNowCheckedExceptionTest_specific_exception_becomes_generic;

import ClassNowCheckedExceptionTest_specific_exception_becomes_generic.*;

public class Main {
    public static void main(String[] args) {
        class X {
			java.io.IOException make() {
				return new A();
			}
		}
		new X().make();
    }
}
