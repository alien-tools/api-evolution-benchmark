package client.ClassNoLongerConcretelyExtensibleTest_making_package_private_method_abstract_in_concretizable_class;

import ClassNoLongerConcretelyExtensibleTest_making_package_private_method_abstract_in_concretizable_class.*;

public class Main {
    public static void main(String[] args) {
        class B extends A { @Override public void m() {} }
    }
}
