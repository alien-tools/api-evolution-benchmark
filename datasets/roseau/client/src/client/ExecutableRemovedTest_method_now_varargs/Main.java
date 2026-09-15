package client.ExecutableRemovedTest_method_now_varargs;

import ExecutableRemovedTest_method_now_varargs.*;

public class Main {
    public static void main(String[] args) {
        new A().m(null, 1);
		new A() { @Override public void m(Object o, int i) {} };
    }
}
