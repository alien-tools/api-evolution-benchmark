package client.FormalTypeParameterChangedTest_second_bound_removed;

import FormalTypeParameterChangedTest_second_bound_removed.*;

public class Main {
    public static void main(String[] args) {
        abstract class X implements CharSequence, Runnable {}
		A<X> a = new A<>();
    }
}
