package day02;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;

import static org.junit.jupiter.api.Assertions.*;

class Test07_Day02CheckIfFirstTwoAndLastTwoCharsSameTest {

    Day02CheckIfFirstTwoAndLastTwoCharsSame obj = new Day02CheckIfFirstTwoAndLastTwoCharsSame();

    @BeforeEach
    void setUp() {
    }

    @AfterEach
    void tearDown() {
    }

    @ParameterizedTest
    @CsvSource(value = {"true, ABAB", "true, BABA", "false, ABCD", "false, C", "true, AB"})
    void checkIfFirstTwoAndLastTwoCharsSame(boolean expected, String actual) {
        assertEquals(expected, obj.checkIfFirstTwoAndLastTwoCharsSame(actual));
    }


    //the same code with valueSource //assertTrue
    @ParameterizedTest
    @ValueSource(strings = {"ABAB", "BABA", "AB"})
    void checkIfFirstTwoAndLastTwoCharsSame2(String str){
        assertTrue(obj.checkIfFirstTwoAndLastTwoCharsSame(str));
    }

    //the same code with valueSource
    @ParameterizedTest
    @ValueSource(strings = {"ABB", "BABCA", "B"})
    void checkIfFirstTwoAndLastTwoCharsSame3(String str){
        assertFalse(obj.checkIfFirstTwoAndLastTwoCharsSame(str));
    }
}