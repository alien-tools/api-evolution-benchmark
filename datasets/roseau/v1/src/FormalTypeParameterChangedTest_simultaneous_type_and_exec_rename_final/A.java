package FormalTypeParameterChangedTest_simultaneous_type_and_exec_rename_final;

			public class A<T> {
				public final <U extends T> void m() {}
			}