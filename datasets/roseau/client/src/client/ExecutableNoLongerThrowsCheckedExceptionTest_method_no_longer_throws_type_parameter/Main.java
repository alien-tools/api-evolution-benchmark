package client.ExecutableNoLongerThrowsCheckedExceptionTest_method_no_longer_throws_type_parameter;

import ExecutableNoLongerThrowsCheckedExceptionTest_method_no_longer_throws_type_parameter.*;

public class Main {
    public static void main(String[] args) {
        try {
			new A<java.io.ObjectStreamException>().m();
		} catch (java.io.ObjectStreamException e) {}
    }
}
