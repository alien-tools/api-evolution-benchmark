package client.FieldTypeChangedTest_generic_wildcard_final_no_break;

import FieldTypeChangedTest_generic_wildcard_final_no_break.*;

public class Main {
    public static void main(String[] args) {
        java.util.List<? extends Number> l = new A().f;
    }
}
