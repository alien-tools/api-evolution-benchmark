package ImplicitObjectTest_object_methods_added_to_interface;

			public interface I {
				@Override boolean equals(Object o);
				int hashCode();
				@Override String toString();
			}