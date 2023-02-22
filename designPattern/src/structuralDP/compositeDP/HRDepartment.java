package structuralDP.compositeDP;

import java.util.List;
import java.util.stream.Collectors;

public class HRDepartment extends Department{

    //we can reach all child classes that are implementing from Department
    //polymorphism
    // from Department interface i get all child classes
    List<Department> chilDepartments;

    //constructor
    //when i create HR class in runner side, i need to pass all my departments
    public HRDepartment(List<Department> childepartments) {

        this.chilDepartments = childepartments;
    }

    @Override
    String getName() {
        //we have two objects: Finance and Sales
        //it is collection of classes
        return chilDepartments.stream().//Finance Obj and Sales obj
                map(Department::getName). //"Finance" and "Sales"
                collect(Collectors.joining(", ")); //"Finance, Sales"

    }

    @Override
    List<String> getEmployee() {
        //flatMap() = map() + Flattening
        //flatMap-->it is like map, it converts one stream to other stream
        return chilDepartments.stream().
                flatMap(d->d.getEmployee(). //
                stream()).collect(Collectors.toList());
    }
}
