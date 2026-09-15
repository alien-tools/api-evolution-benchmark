package FieldRemovedTest_annotation_interface_enum_constant_removed;

			public @interface A {
				E[] value() default E.X;
				enum E { X, Y; }
			}