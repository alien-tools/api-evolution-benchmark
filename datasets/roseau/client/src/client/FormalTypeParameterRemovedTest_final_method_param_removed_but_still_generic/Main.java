package client.FormalTypeParameterRemovedTest_final_method_param_removed_but_still_generic;

import FormalTypeParameterRemovedTest_final_method_param_removed_but_still_generic.*;

public class Main {
    public static void main(String[] args) {
        new A().<String, Integer>m();
    }
}
