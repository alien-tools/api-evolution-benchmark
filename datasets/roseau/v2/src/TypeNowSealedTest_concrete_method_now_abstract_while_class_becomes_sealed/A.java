package TypeNowSealedTest_concrete_method_now_abstract_while_class_becomes_sealed;

			public abstract sealed class A permits B {
				public abstract void m();
			}