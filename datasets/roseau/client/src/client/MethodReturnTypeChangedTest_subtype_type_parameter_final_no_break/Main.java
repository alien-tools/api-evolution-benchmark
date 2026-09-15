package client.MethodReturnTypeChangedTest_subtype_type_parameter_final_no_break;

import MethodReturnTypeChangedTest_subtype_type_parameter_final_no_break.*;

public class Main {
    public static void main(String[] args) {
        CharSequence cs = new A<CharSequence, String>().m();
    }
}
