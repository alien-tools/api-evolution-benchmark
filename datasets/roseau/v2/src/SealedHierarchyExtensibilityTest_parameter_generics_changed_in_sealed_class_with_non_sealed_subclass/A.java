package SealedHierarchyExtensibilityTest_parameter_generics_changed_in_sealed_class_with_non_sealed_subclass;

			public sealed class A permits B {
				public void m(java.util.List<?> l) {}
			}