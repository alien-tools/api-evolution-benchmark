package client.SealedHierarchyExtensibilityTest_protected_field_removed_from_sealed_class_with_non_sealed_subclass;

import SealedHierarchyExtensibilityTest_protected_field_removed_from_sealed_class_with_non_sealed_subclass.*;

public class Main {
    public static void main(String[] args) {
        class C extends B {
			int use() { return f; }
		}
    }
}
