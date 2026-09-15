package client.TypeNowSealedTest_default_method_does_not_become_final_when_interface_becomes_sealed;

import TypeNowSealedTest_default_method_does_not_become_final_when_interface_becomes_sealed.*;

public class Main {
    public static void main(String[] args) {
        class C implements I { @Override public void m() {} }
    }
}
