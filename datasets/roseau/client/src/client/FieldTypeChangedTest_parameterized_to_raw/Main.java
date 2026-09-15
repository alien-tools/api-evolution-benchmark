package client.FieldTypeChangedTest_parameterized_to_raw;

import FieldTypeChangedTest_parameterized_to_raw.*;

public class Main {
    public static void main(String[] args) {
        java.util.List<String> l = new A().f;
		l.add("");
		String s = l.get(0);
    }
}
