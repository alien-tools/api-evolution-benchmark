package client.SealedHierarchyExtensibilityTest_method_type_parameter_changed_in_sealed_class_with_non_sealed_subclass;

import SealedHierarchyExtensibilityTest_method_type_parameter_changed_in_sealed_class_with_non_sealed_subclass.*;

public class Main {
    public static void main(String[] args) {
        class C extends B {
			@Override public <T extends CharSequence & java.io.Serializable> void m(T t) {}
		}
    }
}
