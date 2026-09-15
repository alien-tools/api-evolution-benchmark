package client.SealedHierarchyExtensibilityTest_method_now_static_in_sealed_class_with_non_sealed_subclass;

import SealedHierarchyExtensibilityTest_method_now_static_in_sealed_class_with_non_sealed_subclass.*;

public class Main {
    public static void main(String[] args) {
        class C extends B { @Override public void m() {} }
		new C().m();
    }
}
