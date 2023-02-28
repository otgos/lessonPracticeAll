package day02;

import org.junit.jupiter.api.Nested;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class Test05_GroupingTest {
    //** why we need to group tests?
    // we can group related tests within the same class.. to make more readable

    //we can create class inside class
    //** suppose that we are creating calculator app, and we are testing
    // different functions in different classes within the same class

    @Nested //api
    class testMultiply{
        @ParameterizedTest
        @CsvSource(value = {"-12, -4, 3", "-12, 4, -3", "12, -3, -4"})
        void testMultiplyWithNonZero(int rslt, int num1, int num2){
            assertEquals(rslt, Math.multiplyExact(num1, num2));
        }

        @ParameterizedTest
        @CsvSource(value = {"0, -4, 0", "0, 0, -2", "0, 0, 0"})
        void testMultiplyWithZero(int rslt, int num1, int num2){
            assertEquals(rslt, Math.multiplyExact(num1, num2));
        }

    }//end of first group
    @Nested //api
    class testAddition{

        @ParameterizedTest
        @CsvSource(value = {"-1, -4, 3", "1, 4, -3", "-7, -3, -4"})
        void testAddWithNonZero(int rslt, int num1, int num2){
            assertEquals(rslt, Math.addExact(num1, num2));
        }

        @ParameterizedTest
        @CsvSource(value = {"-4, -4, 0", "-3, 0, -3", "0, 0, 0"})
        void testAddWithZero(int rslt, int num1, int num2){
            assertEquals(rslt, Math.addExact(num1, num2));
        }
    }//end of second group


    //** from the test someone else can understand the methods,
    //** so it serves as documentation

}
