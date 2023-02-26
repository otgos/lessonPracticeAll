package day01;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInfo;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;

public class Test04_BeforeAll_AfterAll {

    @BeforeAll
    static void beforeAll(){
        System.out.println("beforeAll()  Executed");
    }
    @AfterAll
    static void afterAll(){
        System.out.println("afterAll() Executed");
    }

    @Test
    void testArrays1(TestInfo info){
        String str = "Unit Test with Junit";
        String [] actualArray = str.split(" ");
        String []expectedArray = {"Unit", "Test", "with", "Junit"};
        System.out.println(info.getDisplayName()+" executed");
        assertArrayEquals(expectedArray, actualArray, "arrays are not equal");
    }

    //to see if before all and after all
    @Test
    void testArrays2(TestInfo info){
        String str = "test method name should be readable";
        String [] actualArray = str.split(" ");
        String []expectedArray = {"test",  "method", "name", "should", "be", "readable"};
        System.out.println(info.getDisplayName()+" executed");
        assertArrayEquals(expectedArray, actualArray, "arrays are not equal");
    }
}
