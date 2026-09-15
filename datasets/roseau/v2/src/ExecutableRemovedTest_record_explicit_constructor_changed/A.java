package ExecutableRemovedTest_record_explicit_constructor_changed;

			public record A(int i) {
				public A(String s) {
					this(0);
				}
			}