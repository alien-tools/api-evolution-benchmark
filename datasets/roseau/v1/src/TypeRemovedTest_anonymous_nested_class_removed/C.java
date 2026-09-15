package TypeRemovedTest_anonymous_nested_class_removed;

			public class C {
			  public void m() {
			    new Thread() {
			      public static class I {}
			      @Override public void run() {}
			    };
			  }
			}