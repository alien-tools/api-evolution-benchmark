package FormalTypeParameterChangedTest_multi_bound_intersection_renamed_method;

			public class A {
				public <T extends Number & Comparable<T>> void m() {}
			}