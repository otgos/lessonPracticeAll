package structuralDP.decoratorDP;

public class DecoratorRunner {
    public static void main(String[] args) {

        //interface, and new objext from base phone
        Phone phone = new Iphone11ProMax(new IPhone());
        System.out.println("Name: "+phone.getName());
        System.out.println("Price: "+phone.getPrice());
        System.out.println("Camera: "+phone.cameraCount());

    }
}
