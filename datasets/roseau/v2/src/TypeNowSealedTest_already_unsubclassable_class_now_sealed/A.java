package TypeNowSealedTest_already_unsubclassable_class_now_sealed;

			public sealed class A permits A.B {
				private A() {}
				static final class B extends A {}
			}