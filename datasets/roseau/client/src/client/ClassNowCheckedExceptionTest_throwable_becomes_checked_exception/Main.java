package client.ClassNowCheckedExceptionTest_throwable_becomes_checked_exception;

import ClassNowCheckedExceptionTest_throwable_becomes_checked_exception.*;

public class Main {
    public static void main(String[] args) {
        try {
			Throwable t = new A();
			throw new A();
		} catch (Throwable t) {}
    }
}
