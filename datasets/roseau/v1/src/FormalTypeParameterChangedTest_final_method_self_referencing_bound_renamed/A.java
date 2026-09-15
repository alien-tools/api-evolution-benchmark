package FormalTypeParameterChangedTest_final_method_self_referencing_bound_renamed;

			public class A {
				public final <T extends Comparable<T>> void m() {}
			}