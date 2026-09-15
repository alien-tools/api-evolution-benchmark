package client.FieldTypeChangedTest_type_parameter_bound_refinement_final_no_break;

import FieldTypeChangedTest_type_parameter_bound_refinement_final_no_break.*;

public class Main {
    public static void main(String[] args) {
        CharSequence cs = new A<CharSequence, String>().f;
    }
}
