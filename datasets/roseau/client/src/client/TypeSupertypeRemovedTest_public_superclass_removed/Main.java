package client.TypeSupertypeRemovedTest_public_superclass_removed;

import TypeSupertypeRemovedTest_public_superclass_removed.*;

public class Main {
    public static void main(String[] args) {
        A b = new B();
		class X {
			A make() { return new B(); }
		}
		new X().make();
    }
}
