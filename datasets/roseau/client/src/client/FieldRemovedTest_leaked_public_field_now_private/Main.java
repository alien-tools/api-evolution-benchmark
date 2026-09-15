package client.FieldRemovedTest_leaked_public_field_now_private;

import FieldRemovedTest_leaked_public_field_now_private.*;

public class Main {
    public static void main(String[] args) {
        int i = new B().f1;
    }
}
