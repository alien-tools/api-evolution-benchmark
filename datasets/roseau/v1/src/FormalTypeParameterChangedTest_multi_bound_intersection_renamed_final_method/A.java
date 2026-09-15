package FormalTypeParameterChangedTest_multi_bound_intersection_renamed_final_method;

			public class A {
				public final <T extends Number & Comparable<T>> void m() {}
			}