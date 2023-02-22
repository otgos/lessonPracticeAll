package structuralDP.compositeDP;

import java.util.Arrays;

public class CompositeRunner {
    public static void main(String[] args) {

        CompositeRunner compositeRunner = new CompositeRunner();
        compositeRunner.compositeDemo();



    }
    //to make main method less crowded
    //certain things here

    public void compositeDemo(){
        Department financeDepartment  = new Finance();
        Department salesDepartment  = new Sales();
        Department rndDepartment =new RNDDepartment();

        Department hrDepartment = new
                HRDepartment(Arrays.asList(financeDepartment, salesDepartment, rndDepartment));
        System.out.println(hrDepartment.getName());
        System.out.println("*********************");
        System.out.println(hrDepartment.getEmployee());

    }
}
