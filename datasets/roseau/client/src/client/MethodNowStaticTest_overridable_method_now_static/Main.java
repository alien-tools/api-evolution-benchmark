package client.MethodNowStaticTest_overridable_method_now_static;

import MethodNowStaticTest_overridable_method_now_static.*;

public class Main {
    public static void main(String[] args) {
        new A().m();
		new A() { @Override public void m() {} };
    }
}
