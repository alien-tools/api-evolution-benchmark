package client.MethodReturnTypeChangedTest_unboxing_non_final_binary_and_source;

import MethodReturnTypeChangedTest_unboxing_non_final_binary_and_source.*;

public class Main {
    public static void main(String[] args) {
        Integer i = new A().m();
		new A() { @Override public Integer m() { return 0; } };
    }
}
