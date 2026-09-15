package client.ExecutableNowThrowsCheckedExceptionTest_final_method_now_throws_subtype;

import ExecutableNowThrowsCheckedExceptionTest_final_method_now_throws_subtype.*;

public class Main {
    public static void main(String[] args) {
        new A() {
			// Cannot override
		};
		try {
			new A().m();
		} catch (java.io.IOException e) {}
    }
}
