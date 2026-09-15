package client.ImplicitObjectTest_object_methods_removed_from_class;

import ImplicitObjectTest_object_methods_removed_from_class.*;

public class Main {
    public static void main(String[] args) {
        A a = new A();
		int i = a.hashCode();
		String s = a.toString();
		boolean b = a.equals(a);
    }
}
