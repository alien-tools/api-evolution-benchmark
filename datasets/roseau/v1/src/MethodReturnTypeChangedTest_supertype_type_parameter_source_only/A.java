package MethodReturnTypeChangedTest_supertype_type_parameter_source_only;

			public class A<T, U extends T> {
				public U m() { return null; }
			}