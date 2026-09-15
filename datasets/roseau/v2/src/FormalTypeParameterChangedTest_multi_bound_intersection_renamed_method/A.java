package FormalTypeParameterChangedTest_multi_bound_intersection_renamed_method;

			public class A {
				public <U extends Number & Comparable<U>> void m() {}
			}