package day01;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class Test01_Assertions {
    //** there is no main method, but there is run button

    //** explain difference between run button on class level and method level




    @Test //makes this runnable
    public void test(){

    }

    //starting from Junit5, it is not compulsory to start with public access modifier
    //test name suggested to start with test....
    //** lets test method which will test length method from String class
    @Test
    public void testLength(){
        String str = "Hello World";// 11chars
        int actualValue = str.length();
        int expectedValue = 11;
        assertEquals(expectedValue, actualValue);
    }

    //lets test uppercase method from String
    @Test
    public void testUpperCase(){
        String actualValue = "hello".toUpperCase(); //HELLO
        String expetecValue = "HELLO";
        //assertEquals(expetecValue, actualValue);
        //if i want to customize message when there is failure
        assertEquals(expetecValue, actualValue, "UpperCase method failed");

    }
    //test Math.addExact() from core Java
    @Test
    void testSum(){
        int num1 = 10;
        int num2 = 15;
        int actualValue = Math.addExact(num1, num2);
        int expectedValue  = 25;
        assertEquals(expectedValue, actualValue);

    }
    //we don't need to create variable separately
    //test string.Contains()
    @Test
    void testContains(){
        assertEquals(false, "Junit".contains("z"));
    }

}
