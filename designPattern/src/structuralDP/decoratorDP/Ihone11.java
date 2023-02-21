package structuralDP.decoratorDP;

public class Ihone11 extends PhoneDecorator{
    public Ihone11(IPhone basicPhone) {
        super(basicPhone);
    }

    @Override
    public String getName() {
        return super.getName()+11;
    }

    //if camera count or price is the same with base phone, we
    // dont need to override. it will get default value
    //so we did not extended from interface
}
