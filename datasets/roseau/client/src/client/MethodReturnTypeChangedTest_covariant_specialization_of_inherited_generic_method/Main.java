package client.MethodReturnTypeChangedTest_covariant_specialization_of_inherited_generic_method;

import MethodReturnTypeChangedTest_covariant_specialization_of_inherited_generic_method.*;

public class Main {
    public static void main(String[] args) {
        class C extends A { public String get() { return "client"; } }
		A a = new C();
		String s = a.get();
    }
}
