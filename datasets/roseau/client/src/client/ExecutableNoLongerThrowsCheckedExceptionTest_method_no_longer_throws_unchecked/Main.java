package client.ExecutableNoLongerThrowsCheckedExceptionTest_method_no_longer_throws_unchecked;

import ExecutableNoLongerThrowsCheckedExceptionTest_method_no_longer_throws_unchecked.*;

public class Main {
    public static void main(String[] args) {
        try {
			new A().m();
		} catch (RuntimeException e) {}
    }
}
