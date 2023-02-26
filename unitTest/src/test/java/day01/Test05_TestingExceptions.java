package day01;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertThrows;

public class Test05_TestingExceptions {
    //test expected exceptions
    @Test
    void testException(){
        String str = "Java codes are tested by JUnit.";
        assertThrows(NullPointerException.class, ()->{
            System.out.println("textException() executed");
            str.length();
        });
    }
    //test method for division
    @Test
    void testException2(){
        int num1 = 5;
        int num2 = 0;
        assertThrows(ArithmeticException.class, ()->{
            System.out.println(num1/num2);
        });

        //*** why we need to test exception?? we may get some other exception
        //if confirmed, we can handle
        //RuntimeException is also fine... but it is too much burden for JVM

    }
    @Test
    void testException3(){
        int num1 = 1;
        int num2 = 0;
        assertThrows(ArithmeticException.class, ()->divide(num1, num2));
    }
    private int divide(int num1, int num2){
        return num1/num2;
    }
}
