package ImplicitObjectTest_object_methods_removed_from_interface;

			public interface I {
				@Override boolean equals(Object o);
				int hashCode();
				@Override String toString();
			}