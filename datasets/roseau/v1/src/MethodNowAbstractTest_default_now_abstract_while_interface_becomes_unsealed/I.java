package MethodNowAbstractTest_default_now_abstract_while_interface_becomes_unsealed;

			public sealed interface I permits X {
				default void m() {}
			}