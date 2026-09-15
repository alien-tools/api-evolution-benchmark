package client.ClassNoLongerConcretelyExtensibleTest_adding_package_private_abstract_method_to_concretizable_class;

import ClassNoLongerConcretelyExtensibleTest_adding_package_private_abstract_method_to_concretizable_class.*;

public class Main {
    public static void main(String[] args) {
        class B extends A { @Override public void m() {} }
    }
}
