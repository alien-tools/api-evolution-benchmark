package client.FieldTypeChangedTest_unrelated_type_parameters_source_only;

import FieldTypeChangedTest_unrelated_type_parameters_source_only.*;

public class Main {
    public static void main(String[] args) {
        Integer i = new A<Integer, String>().f;
    }
}
