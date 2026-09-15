package client.ClassNoLongerConcretelyExtensibleTest_now_abstract_method_in_unconcretizable_class;

import ClassNoLongerConcretelyExtensibleTest_now_abstract_method_in_unconcretizable_class.*;

public class Main {
    public static void main(String[] args) {
        abstract class B extends A { @Override public void m() {} }
    }
}
