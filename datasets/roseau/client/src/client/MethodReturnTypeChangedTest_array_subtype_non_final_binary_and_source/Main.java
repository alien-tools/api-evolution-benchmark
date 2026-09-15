package client.MethodReturnTypeChangedTest_array_subtype_non_final_binary_and_source;

import MethodReturnTypeChangedTest_array_subtype_non_final_binary_and_source.*;

public class Main {
    public static void main(String[] args) {
        java.io.InputStream[] a = new A().m();
		new A() { @Override public java.io.InputStream[] m() { return new java.io.InputStream[] { null }; } };
    }
}
