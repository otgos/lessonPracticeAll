package creationalDP.singletonDP;

public class SingletonPatternDemo {
    public static void main(String[] args) {
        //SingletonObject obj1 = new SingletonObject(); //constructor is private

        //we will create obj without using new keyword
        SingletonObject obj2 = SingletonObject.getInstance();
        System.out.println(obj2.message);  //HELLO
        obj2.changeMethod();  // HELLO Batch 110-111

        //test if it is singleton ot not
        SingletonObject obj3 = SingletonObject.getInstance(); //
        System.out.println("for Obj3 : "+obj3.message);
    }
}
