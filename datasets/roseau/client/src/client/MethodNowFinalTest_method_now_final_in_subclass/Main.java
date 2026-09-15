package client.MethodNowFinalTest_method_now_final_in_subclass;

import MethodNowFinalTest_method_now_final_in_subclass.*;

public class Main {
    public static void main(String[] args) {
        new B() { @Override public void m() {} };
    }
}
