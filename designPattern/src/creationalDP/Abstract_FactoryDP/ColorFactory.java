package creationalDP.Abstract_FactoryDP;

public class ColorFactory extends AbstractFactory{
    @Override
    Color getColor(String color) {
        if(color==null){
            return null;
        }
        if(color.equalsIgnoreCase("RED")){
            return new Red();
        }else if(color.equalsIgnoreCase("GREEN")){
            return new Green();
        }else if(color.equalsIgnoreCase("BLUE")){
            return new Blue();
        }
        return null;
    }

    //this factory produces color not shape...
    // so if we get any request about shape then we should get null
    @Override
    Shape getShape(String shape) {
        return null;
    }
}
