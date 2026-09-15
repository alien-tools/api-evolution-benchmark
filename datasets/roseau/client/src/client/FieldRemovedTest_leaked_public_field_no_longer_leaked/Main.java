package client.FieldRemovedTest_leaked_public_field_no_longer_leaked;

import FieldRemovedTest_leaked_public_field_no_longer_leaked.*;

public class Main {
    public static void main(String[] args) {
        int i = new B().f1;
    }
}
