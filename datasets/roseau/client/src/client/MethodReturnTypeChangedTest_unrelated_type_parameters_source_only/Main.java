package client.MethodReturnTypeChangedTest_unrelated_type_parameters_source_only;

import MethodReturnTypeChangedTest_unrelated_type_parameters_source_only.*;

public class Main {
    public static void main(String[] args) {
        Integer i = new A<Integer, String>().m();
    }
}
