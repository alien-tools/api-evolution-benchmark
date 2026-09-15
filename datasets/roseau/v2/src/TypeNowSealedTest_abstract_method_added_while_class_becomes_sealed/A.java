package TypeNowSealedTest_abstract_method_added_while_class_becomes_sealed;

			public abstract sealed class A permits B {
				public abstract void m();
			}