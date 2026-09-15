package SealedHierarchyExtensibilityTest_return_type_changed_in_sealed_class_with_non_sealed_subclass;

			public sealed class A permits B {
				public java.util.List<?> m() { return java.util.List.of(); }
			}