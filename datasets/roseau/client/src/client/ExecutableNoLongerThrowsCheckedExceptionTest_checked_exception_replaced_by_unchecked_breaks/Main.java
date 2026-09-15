package client.ExecutableNoLongerThrowsCheckedExceptionTest_checked_exception_replaced_by_unchecked_breaks;

import ExecutableNoLongerThrowsCheckedExceptionTest_checked_exception_replaced_by_unchecked_breaks.*;

public class Main {
    public static void main(String[] args) {
        try { new A().m(); } catch (java.io.IOException e) {}
    }
}
