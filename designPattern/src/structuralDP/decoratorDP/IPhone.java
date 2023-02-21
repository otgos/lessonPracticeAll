package structuralDP.decoratorDP;

public class IPhone implements Phone{
    //all my classes should inherit from this class not from Interface. why?
    //t
    //this will be my base class and all iphones are inherited from this class
    //since this class is the base class, all methods will return minimums
    @Override
    public String getName() {
        //common name for all Iphone
        return "IPhone";
    }


    @Override
    public int cameraCount() {
        return 2;
    }

    @Override
    public double getPrice() {
        return 499.9;
    }
}
