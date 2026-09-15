package client.ExecutableParameterGenericsChangedTest_method_first_param_added_and_used_as_part_of_parameter_type;

import ExecutableParameterGenericsChangedTest_method_first_param_added_and_used_as_part_of_parameter_type.*;

public class Main {
    public static void main(String[] args) {
        new A().m(java.util.List.<Object>of());
		new A() {
			@Override public void m(java.util.List<Object> l) {}
		}.m(java.util.List.<Object>of());
    }
}
