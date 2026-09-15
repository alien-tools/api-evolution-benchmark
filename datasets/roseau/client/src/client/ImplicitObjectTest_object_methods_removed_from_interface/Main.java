package client.ImplicitObjectTest_object_methods_removed_from_interface;

import ImplicitObjectTest_object_methods_removed_from_interface.*;

public class Main {
    public static void main(String[] args) {
        I i = new I(){};
		int j = i.hashCode();
		String s = i.toString();
		boolean b = i.equals(i);
    }
}
