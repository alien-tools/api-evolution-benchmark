package client.MethodReturnTypeChangedTest_primitive_narrowing_binary_and_source;

import MethodReturnTypeChangedTest_primitive_narrowing_binary_and_source.*;

public class Main {
    public static void main(String[] args) {
        long l = new A().m();
		new A() { @Override public long m() { return 0L; } };
    }
}
