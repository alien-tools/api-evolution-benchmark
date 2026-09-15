package TypeNowSealedTest_default_method_does_not_become_final_when_interface_becomes_sealed;

			public sealed interface I permits X {
				default void m() {}
			}