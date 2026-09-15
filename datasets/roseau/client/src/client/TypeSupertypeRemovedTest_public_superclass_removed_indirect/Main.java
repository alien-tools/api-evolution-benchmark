package client.TypeSupertypeRemovedTest_public_superclass_removed_indirect;

import TypeSupertypeRemovedTest_public_superclass_removed_indirect.*;

public class Main {
    public static void main(String[] args) {
        A c = new C();
		class X {
			A make() { return new C(); }
		}
		new X().make();
    }
}
