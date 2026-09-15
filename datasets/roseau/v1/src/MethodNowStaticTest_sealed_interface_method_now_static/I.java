package MethodNowStaticTest_sealed_interface_method_now_static;

			public sealed interface I permits A {
				default void m() {}
			}