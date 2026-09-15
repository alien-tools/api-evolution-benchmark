package client.ExecutableRemovedTest_abstract_class_default_constructor_now_protected;

import ExecutableRemovedTest_abstract_class_default_constructor_now_protected.*;

public class Main {
    public static void main(String[] args) {
        class B extends A { B() { super(); } }
		A a = new A() {};
    }
}
