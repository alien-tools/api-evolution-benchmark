package client.MethodReturnTypeChangedTest_raw_subtype_to_parameterized_supertype_final_binary_only;

import MethodReturnTypeChangedTest_raw_subtype_to_parameterized_supertype_final_binary_only.*;

public class Main {
    public static void main(String[] args) {
        java.util.List<String> f = new A().m();
		f.add("");
		String s = f.get(0);
    }
}
