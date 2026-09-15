package MethodReturnTypeChangedTest_subtype_type_parameter_non_final_source_only;

			public class A<T, U extends T> {
				public U m() { return null; }
			}