package client.MethodNowAbstractTest_implicitly_abstract_to_abstract;

import MethodNowAbstractTest_implicitly_abstract_to_abstract.*;

public class Main {
    public static void main(String[] args) {
        new I() {
			@Override public void m() {}
		};
    }
}
