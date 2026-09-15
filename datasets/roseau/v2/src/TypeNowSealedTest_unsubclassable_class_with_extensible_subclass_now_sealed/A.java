package TypeNowSealedTest_unsubclassable_class_with_extensible_subclass_now_sealed;

			public sealed class A permits B {
				A() {}
			}