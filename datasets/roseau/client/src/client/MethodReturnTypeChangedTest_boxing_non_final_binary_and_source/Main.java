package client.MethodReturnTypeChangedTest_boxing_non_final_binary_and_source;

import MethodReturnTypeChangedTest_boxing_non_final_binary_and_source.*;

public class Main {
    public static void main(String[] args) {
        int i = new A().m();
		new A() { @Override public int m() { return 0; } };
    }
}
