package day02;

import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.RepeatedTest;

import java.util.Random;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class Test02_RepeatTestMultipleTimes {
    //If we want to repeat test

    @RepeatedTest(5)
    void testSubstring(){
        assertEquals("Java", "Java is must".substring(0, 4));
        System.out.println("testSubstring() executed.");
    }

    @RepeatedTest(3)
    void testRepeated(){
        assertEquals(2, Math.addExact(1, 1));
    }

    //***why we need to repeat the same test several times?
    // if it passes once, then it will pass for the rest

    Random rm = new Random();
    @RepeatedTest(5)
    @Disabled // will not run when test class run on class level
    void testMathExactWithRandom(){
        //random number from 0 to 9
        int num1 = rm.nextInt(10);
        int num2 = rm.nextInt(10);
        assertEquals(num1+num2, Math.addExact(num1, num2));
        System.out.println("num1: "+num1 + "; num2: "+num2);
    }
}
