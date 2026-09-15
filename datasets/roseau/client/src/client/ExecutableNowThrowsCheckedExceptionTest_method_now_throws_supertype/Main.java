package client.ExecutableNowThrowsCheckedExceptionTest_method_now_throws_supertype;

import ExecutableNowThrowsCheckedExceptionTest_method_now_throws_supertype.*;

public class Main {
    public static void main(String[] args) {
        try {
			new A().m();
		} catch (java.io.ObjectStreamException e) {}
    }
}
