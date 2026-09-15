package client.FieldRemovedTest_field_visibility_protected_to_private;

import FieldRemovedTest_field_visibility_protected_to_private.*;

public class Main {
    public static void main(String[] args) {
        new A() {{
			f = 0;
		}};
    }
}
