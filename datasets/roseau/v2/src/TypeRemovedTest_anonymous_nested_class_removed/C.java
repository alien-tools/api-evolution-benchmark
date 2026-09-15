package TypeRemovedTest_anonymous_nested_class_removed;

			public class C {
			  public void m() {
			    new Thread() {
			      @Override public void run() {}
			    };
			  }
			}