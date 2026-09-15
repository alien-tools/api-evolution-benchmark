package client.FormalTypeParameterChangedTest_simultaneous_type_and_exec_rename;

import FormalTypeParameterChangedTest_simultaneous_type_and_exec_rename.*;

public class Main {
    public static void main(String[] args) {
        new A<String>().<String>m();
    }
}
