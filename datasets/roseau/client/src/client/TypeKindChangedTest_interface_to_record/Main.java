package client.TypeKindChangedTest_interface_to_record;

import TypeKindChangedTest_interface_to_record.*;

public class Main {
    public static void main(String[] args) {
        class C implements A {};
		C c = new C(); // Trigger the linker
    }
}
