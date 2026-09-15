package client.FieldTypeChangedTest_type_parameter_bound_refinement_non_final_source_only;

import FieldTypeChangedTest_type_parameter_bound_refinement_non_final_source_only.*;

public class Main {
    public static void main(String[] args) {
        new A<CharSequence, String>().f = new StringBuilder();
    }
}
