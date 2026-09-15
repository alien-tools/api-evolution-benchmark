package client.ExecutableNoLongerThrowsCheckedExceptionTest_declared_exception_becomes_unchecked_is_compatible;

import ExecutableNoLongerThrowsCheckedExceptionTest_declared_exception_becomes_unchecked_is_compatible.*;

public class Main {
    public static void main(String[] args) {
        try { new A().m(); } catch (E e) {}
		class C extends A { @Override public void m() throws E {} }
    }
}
