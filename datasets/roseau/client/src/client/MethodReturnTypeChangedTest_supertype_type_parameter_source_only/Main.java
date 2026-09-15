package client.MethodReturnTypeChangedTest_supertype_type_parameter_source_only;

import MethodReturnTypeChangedTest_supertype_type_parameter_source_only.*;

public class Main {
    public static void main(String[] args) {
        String s = new A<CharSequence, String>().m();
    }
}
