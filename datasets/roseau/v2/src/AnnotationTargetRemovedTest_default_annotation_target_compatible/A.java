package AnnotationTargetRemovedTest_default_annotation_target_compatible;
			@java.lang.annotation.Target({
				java.lang.annotation.ElementType.TYPE, java.lang.annotation.ElementType.FIELD,
				java.lang.annotation.ElementType.METHOD, java.lang.annotation.ElementType.PARAMETER,
				java.lang.annotation.ElementType.CONSTRUCTOR, java.lang.annotation.ElementType.LOCAL_VARIABLE,
				java.lang.annotation.ElementType.ANNOTATION_TYPE, java.lang.annotation.ElementType.PACKAGE,
				java.lang.annotation.ElementType.TYPE_PARAMETER, java.lang.annotation.ElementType.MODULE,
				java.lang.annotation.ElementType.RECORD_COMPONENT
			})
			public @interface A {
				int value();
			}