package structuralDP.decoratorDP;

public class PhoneDecorator implements Phone{

    //because concrete class may change.Iphone may become UPhone. we are trying to create loose coupling

    //protected because it will be used by classes which will extend PhoneDecorator
    //
    protected Phone basicPhone;


    //*********create constructor
    //change parameter to concrete IPhone class, so that you can run method body
    //PhoneDecorator is like bridge
    public PhoneDecorator(IPhone basicPhone) {
        this.basicPhone = basicPhone;
    }

    @Override
    public String getName() {
        return basicPhone.getName();
    }////Ihone -->will get basic values

    @Override
    public int cameraCount() {
        return basicPhone.cameraCount();
    }///2 -->will get basic values

    @Override
    public double getPrice() {
        return basicPhone.getPrice();
    }///499.9 -->will get basic values

    //** when we create phones we will use Decorator class
}
