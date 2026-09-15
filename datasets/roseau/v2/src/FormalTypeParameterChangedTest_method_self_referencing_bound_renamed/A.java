package FormalTypeParameterChangedTest_method_self_referencing_bound_renamed;

			public class A {
				public <U extends Comparable<U>> void m() {}
			}