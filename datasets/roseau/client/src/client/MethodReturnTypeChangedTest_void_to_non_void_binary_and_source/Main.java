package client.MethodReturnTypeChangedTest_void_to_non_void_binary_and_source;

import MethodReturnTypeChangedTest_void_to_non_void_binary_and_source.*;

public class Main {
    public static void main(String[] args) {
        new A().m();
		new A() { @Override public void m() {} };
    }
}
