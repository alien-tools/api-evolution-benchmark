package client.ExecutableNowThrowsCheckedExceptionTest_final_class_method_now_throws_subtype;

import ExecutableNowThrowsCheckedExceptionTest_final_class_method_now_throws_subtype.*;

public class Main {
    public static void main(String[] args) {
        try {
			new A().m();
		} catch (java.io.IOException e) {}
    }
}
