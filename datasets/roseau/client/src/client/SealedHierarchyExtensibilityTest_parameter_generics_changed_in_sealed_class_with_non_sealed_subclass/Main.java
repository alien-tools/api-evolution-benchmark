package client.SealedHierarchyExtensibilityTest_parameter_generics_changed_in_sealed_class_with_non_sealed_subclass;

import SealedHierarchyExtensibilityTest_parameter_generics_changed_in_sealed_class_with_non_sealed_subclass.*;

public class Main {
    public static void main(String[] args) {
        class C extends B {
			@Override public void m(java.util.List<String> l) {}
		}
    }
}
