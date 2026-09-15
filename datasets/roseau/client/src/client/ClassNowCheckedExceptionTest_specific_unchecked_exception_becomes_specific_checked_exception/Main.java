package client.ClassNowCheckedExceptionTest_specific_unchecked_exception_becomes_specific_checked_exception;

import ClassNowCheckedExceptionTest_specific_unchecked_exception_becomes_specific_checked_exception.*;

public class Main {
    public static void main(String[] args) {
        class X {
			void consume(IllegalArgumentException e) {}
		}
		new X().consume(new A());
    }
}
