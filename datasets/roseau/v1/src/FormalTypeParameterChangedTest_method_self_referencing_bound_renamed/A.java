package FormalTypeParameterChangedTest_method_self_referencing_bound_renamed;

			public class A {
				public <T extends Comparable<T>> void m() {}
			}