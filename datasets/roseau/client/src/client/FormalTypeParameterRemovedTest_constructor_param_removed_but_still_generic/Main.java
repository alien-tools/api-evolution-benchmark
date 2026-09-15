package client.FormalTypeParameterRemovedTest_constructor_param_removed_but_still_generic;

import FormalTypeParameterRemovedTest_constructor_param_removed_but_still_generic.*;

public class Main {
    public static void main(String[] args) {
        new <String, Integer>A();
    }
}
