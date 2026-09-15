package client.FieldRemovedTest_annotation_interface_enum_constant_removed;

import FieldRemovedTest_annotation_interface_enum_constant_removed.*;

public class Main {
    public static void main(String[] args) {
        @A(A.E.Y) int i;
		System.out.println(A.E.Y);
    }
}
