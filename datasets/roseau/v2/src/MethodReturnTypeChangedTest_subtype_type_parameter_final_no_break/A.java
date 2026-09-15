package MethodReturnTypeChangedTest_subtype_type_parameter_final_no_break;

			public class A<T, U extends T> {
				public final U m() { return null; }
			}