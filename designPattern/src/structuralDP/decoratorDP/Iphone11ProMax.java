package structuralDP.decoratorDP;

//names are similar
public class Iphone11ProMax extends Iphone11Pro{

    public Iphone11ProMax(IPhone basicPhone) {
        super(basicPhone);
    }

    @Override
    public double getPrice() {
        return super.getPrice()+100;
    }

    @Override
    public String getName() {
        return super.getName()+" Max";
    }
    //if camera count is 3 we donot need to override


    //if we want extra feature we can add
    public String extraMethod(){
        return "Gold Color";
    }
}
