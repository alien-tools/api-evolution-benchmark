package client.ClassNowFinalTest_unconcretizable_class_becomes_final;

import ClassNowFinalTest_unconcretizable_class_becomes_final.*;

public class Main {
    public static void main(String[] args) {
        abstract class B extends A { @Override public void m() {} }
    }
}
