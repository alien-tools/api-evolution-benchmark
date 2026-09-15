package client.MethodReturnTypeChangedTest_reference_subtype_non_final_binary_and_source;

import MethodReturnTypeChangedTest_reference_subtype_non_final_binary_and_source.*;

public class Main {
    public static void main(String[] args) {
        java.io.InputStream is = new A().m();
		new A() { @Override public java.io.InputStream m() { return null; } };
    }
}
