package client.TypeKindChangedTest_interface_to_enum;

import TypeKindChangedTest_interface_to_enum.*;

public class Main {
    public static void main(String[] args) {
        class C implements A {};
		C c = new C(); // Trigger the linker
    }
}
