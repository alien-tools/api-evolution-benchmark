package client.ExecutableNowThrowsCheckedExceptionTest_constructor_now_throws_subtype;

import ExecutableNowThrowsCheckedExceptionTest_constructor_now_throws_subtype.*;

public class Main {
    public static void main(String[] args) {
        try {
			new A();
		} catch (java.io.IOException e) {}
    }
}
