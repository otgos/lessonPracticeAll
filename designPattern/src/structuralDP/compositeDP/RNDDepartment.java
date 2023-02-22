package structuralDP.compositeDP;

import java.util.Arrays;
import java.util.List;

public class RNDDepartment extends Department{
    @Override
    String getName() {
        return "RnD";
    }

    @Override
    List<String> getEmployee() {
        return Arrays.asList("R1", "R2");
    }
}
