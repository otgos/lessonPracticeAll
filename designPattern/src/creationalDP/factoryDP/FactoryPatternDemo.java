package creationalDP.factoryDP;

public class FactoryPatternDemo {
    public static void main(String[] args) {
        Shape circle = new Circle();
        circle.draw();
        Shape rectangle = new Rectangle();
        rectangle.draw();
        Shape square = new Square();
        square.draw();

        //for this method, i need to know names of concrete classes? do I need this? what if I just tell need circle?
        //it makes me depend on the class names
        System.out.println("************ Shape Factory *************");

        ShapeFactory shapeFactory = new ShapeFactory();
        Shape shape1 = shapeFactory.getShape("Daire");
        Shape shape2 = shapeFactory.getShape("Rectangle");
        Shape shape3 = shapeFactory.getShape("Square");

        shape1.draw();
        shape2.draw();
        shape3.draw();
    }
}
