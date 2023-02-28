package day02;


import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.junit.jupiter.api.Assertions.*;

class Test06_Day02RemoveATest {

    Day02RemoveA removeA;

    @BeforeEach
    void setUp() {
        removeA=new Day02RemoveA();
        System.out.println("@BeforeEach executed...");
    }
     @AfterEach
    void tearDown(){
        removeA = null;
        System.out.println("AfterEach executed...");
    }

    @ParameterizedTest
    @CsvSource(value = {"BC, AABC", "BA, ABA", "BC, BAC", "BB, BB"})
    void deleteAifItIsInFirstTwoChars(String expected, String actual) {
        assertEquals(expected, removeA.deleteAifItIsInFirstTwoChars(actual));
        System.out.println("method running");
    }
}