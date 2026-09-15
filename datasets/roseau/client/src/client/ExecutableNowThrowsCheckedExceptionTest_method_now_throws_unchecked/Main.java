package client.ExecutableNowThrowsCheckedExceptionTest_method_now_throws_unchecked;

import ExecutableNowThrowsCheckedExceptionTest_method_now_throws_unchecked.*;

public class Main {
    public static void main(String[] args) {
        try {
			new A().m();
		} catch (java.io.IOException e) {}
    }
}
