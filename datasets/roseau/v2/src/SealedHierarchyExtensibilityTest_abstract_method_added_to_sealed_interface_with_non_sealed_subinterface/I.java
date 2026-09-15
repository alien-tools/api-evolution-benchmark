package SealedHierarchyExtensibilityTest_abstract_method_added_to_sealed_interface_with_non_sealed_subinterface;

			public sealed interface I permits J {
				void m();
			}