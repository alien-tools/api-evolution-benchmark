package client.TypeKindChangedTest_interface_to_class;

import TypeKindChangedTest_interface_to_class.*;

public class Main {
    public static void main(String[] args) {
        class C implements A {};
		C c = new C(); // Trigger the linker
    }
}
