package client.ExecutableNoLongerThrowsCheckedExceptionTest_method_no_longer_throws_indirect;

import ExecutableNoLongerThrowsCheckedExceptionTest_method_no_longer_throws_indirect.*;

public class Main {
    public static void main(String[] args) {
        try {
			new B().m();
		} catch (java.io.IOException e) {}
    }
}
