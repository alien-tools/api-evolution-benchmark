package client.SealedHierarchyExtensibilityTest_return_type_changed_in_sealed_class_with_non_sealed_subclass;

import SealedHierarchyExtensibilityTest_return_type_changed_in_sealed_class_with_non_sealed_subclass.*;

public class Main {
    public static void main(String[] args) {
        class C extends B {
			@Override public java.util.List<?> m() { return java.util.List.of(); }
		}
    }
}
