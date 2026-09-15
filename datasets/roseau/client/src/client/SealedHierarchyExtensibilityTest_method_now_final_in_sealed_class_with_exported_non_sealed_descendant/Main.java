package client.SealedHierarchyExtensibilityTest_method_now_final_in_sealed_class_with_exported_non_sealed_descendant;

import SealedHierarchyExtensibilityTest_method_now_final_in_sealed_class_with_exported_non_sealed_descendant.*;

public class Main {
    public static void main(String[] args) {
        class D extends C { @Override public void m() {} }
    }
}
