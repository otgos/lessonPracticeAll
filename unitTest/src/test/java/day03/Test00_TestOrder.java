package day03;

import org.junit.jupiter.api.*;

import static org.junit.jupiter.api.Assertions.assertEquals;
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class Test00_TestOrder {
    private static StringBuilder output = new StringBuilder();
    @Test
    @Order(2)
    void testVA(){
        output.append("A");
    }

    @Test
    @Order(1)
    void testB(){
        output.append("B");
    }


    @Test
    @Order(3)
    void testC(){
        output.append("C");
    }
    @AfterAll
    public static void assertOutput(){

        assertEquals("ABC", output.toString());
        System.out.println(output.toString());
    }
}
