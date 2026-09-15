package client.MethodReturnTypeChangedTest_subtype_type_parameter_non_final_source_only;

import MethodReturnTypeChangedTest_subtype_type_parameter_non_final_source_only.*;

public class Main {
    public static void main(String[] args) {
        new A<CharSequence, String>().m();
		new A<CharSequence, String>() { @Override public CharSequence m() { return null; } };
    }
}
