package client.ExecutableNowThrowsCheckedExceptionTest_constructor_now_throws_supertype;

import ExecutableNowThrowsCheckedExceptionTest_constructor_now_throws_supertype.*;

public class Main {
    public static void main(String[] args) {
        try {
			new A();
		} catch (java.io.ObjectStreamException e) {}
    }
}
