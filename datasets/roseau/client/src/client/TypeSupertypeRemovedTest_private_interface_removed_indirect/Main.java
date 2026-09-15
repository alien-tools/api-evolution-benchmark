package client.TypeSupertypeRemovedTest_private_interface_removed_indirect;

import TypeSupertypeRemovedTest_private_interface_removed_indirect.*;

public class Main {
    public static void main(String[] args) {
        B c = new C(); // Can't upcast (A)
    }
}
