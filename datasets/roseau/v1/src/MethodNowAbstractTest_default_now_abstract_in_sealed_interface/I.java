package MethodNowAbstractTest_default_now_abstract_in_sealed_interface;

			public sealed interface I permits X {
				default void m() {}
			}