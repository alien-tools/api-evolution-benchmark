package client.ClassNowCheckedExceptionTest_checked_exception_becomes_specific;

import ClassNowCheckedExceptionTest_checked_exception_becomes_specific.*;

public class Main {
    public static void main(String[] args) {
        try {
			Exception e = new A();
			throw new A();
		} catch (A e) {}
		try {
			throw new A();
		} catch (Exception e) {}
    }
}
