package TypeNowSealedTest_abstract_method_added_while_interface_becomes_sealed;

			public sealed interface I permits X {
				void m();
			}