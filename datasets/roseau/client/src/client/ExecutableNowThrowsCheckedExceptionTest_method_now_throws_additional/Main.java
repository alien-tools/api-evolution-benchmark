package client.ExecutableNowThrowsCheckedExceptionTest_method_now_throws_additional;

import ExecutableNowThrowsCheckedExceptionTest_method_now_throws_additional.*;

public class Main {
    public static void main(String[] args) {
        try {
			new A().m();
		} catch (java.io.IOException e) {}
    }
}
