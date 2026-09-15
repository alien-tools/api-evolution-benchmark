package client.ExecutableNoLongerThrowsCheckedExceptionTest_method_no_longer_throws_one_of_multiple;

import ExecutableNoLongerThrowsCheckedExceptionTest_method_no_longer_throws_one_of_multiple.*;

public class Main {
    public static void main(String[] args) {
        try {
			new A().m();
		} catch (java.io.IOException | java.sql.SQLException e) {}
    }
}
