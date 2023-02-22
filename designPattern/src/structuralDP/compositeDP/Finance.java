package structuralDP.compositeDP;

import java.util.Arrays;
import java.util.List;

public class Finance extends Department{
    //name of deparment
    @Override
    String getName() {
        return "Finance";
    }

    @Override
    List<String> getEmployee() {
        return Arrays.asList("F1", "F2", "F3");
    }
}
