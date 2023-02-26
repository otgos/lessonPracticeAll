package day01;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInfo;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class test03_BeforeEach_AfterEach {

    //@BeforeEach and @AfterEach mean the annotated method should be
    // executed before or after each test method in the test class.

    String str ;

    @BeforeEach //executed before each test method
    void beforeEach(){
        //assigning value to str before each test
        str = "test methods should be simple";
        System.out.println("beforeEach() executed. Value of str: "+str);
    }
    @AfterEach
    void afterEach(){
        str="";
        System.out.println("afterEach() executed. Value of str: "+str);
    }
    @Test
    void testArrays(TestInfo info){ //to display running method information
        String []  actualArray = str.split(" ");
        String [] expectedArray = {"test", "methods", "should", "be", "simple"};
        System.out.println(info.getDisplayName()+" running...");

        assertTrue(Arrays.equals(expectedArray, actualArray));
    }

    //in the same class
    @Test
    void testStringLenght(TestInfo info){
        int actualValue = str.length();
        int expectedValue = 29;
        assertEquals(expectedValue, actualValue);
        System.out.println(info.getDisplayName()+" executed");
    }

    //** what is problem here???
    //Each time new method needs to set value for string...

}
