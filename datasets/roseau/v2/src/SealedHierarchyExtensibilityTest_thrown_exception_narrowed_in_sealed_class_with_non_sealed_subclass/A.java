package SealedHierarchyExtensibilityTest_thrown_exception_narrowed_in_sealed_class_with_non_sealed_subclass;

			public sealed class A permits B {
				public void m() throws java.io.FileNotFoundException {}
			}