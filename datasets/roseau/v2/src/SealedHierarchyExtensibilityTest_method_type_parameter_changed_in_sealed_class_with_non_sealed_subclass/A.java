package SealedHierarchyExtensibilityTest_method_type_parameter_changed_in_sealed_class_with_non_sealed_subclass;

			public sealed class A permits B {
				public <T extends CharSequence> void m(T t) {}
			}