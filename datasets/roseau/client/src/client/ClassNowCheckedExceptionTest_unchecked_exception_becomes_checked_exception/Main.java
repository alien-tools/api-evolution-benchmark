package client.ClassNowCheckedExceptionTest_unchecked_exception_becomes_checked_exception;

import ClassNowCheckedExceptionTest_unchecked_exception_becomes_checked_exception.*;

public class Main {
    public static void main(String[] args) {
        class X {
			void consume(RuntimeException e) {}
		}
		new X().consume(new A());
    }
}
