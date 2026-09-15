package client.ClassNowCheckedExceptionTest_exception_becomes_throwable;

import ClassNowCheckedExceptionTest_exception_becomes_throwable.*;

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
