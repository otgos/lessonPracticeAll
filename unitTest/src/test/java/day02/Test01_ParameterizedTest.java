package day02;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvFileSource;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class Test01_ParameterizedTest {

    //** Scenario: we want to test length of some strings
    @Test
    void testLength(){

        assertTrue("Mustafa".length()>0);
        assertTrue("Fatih".length()>0);
        assertTrue("Ali".length()>0);
        // ** repeated our selves several times.Can we write on assertTrue ?
        //then we can use parameterized
      }

      // the same method but we use ParameterizedTest
    @ParameterizedTest //to indicate this will be parameterized test
    @ValueSource(strings = {"Mustafa", "Fatih", "Ali"})
    void testLength2(String str){
        assertTrue(str.length()>0);
    }

    //upperccase
    @Test
    void testUpperCase(){
        String str1 = "Hello";
        String str2 = "Java";
        String str3 = "Test";

        assertEquals("HELLO", str1.toUpperCase());
        assertEquals("JAVA", str2.toUpperCase());
        assertEquals("TEST", str3.toUpperCase());
    }

    //coma -seperated. because this is similar to map
    @ParameterizedTest
    @CsvSource(value=
            {
                    "HELLO, Hello",
                    "JAVA, Java",
                    "TEST, Test"
            })
    void testUpperCase2 (String str1, String str2){
        assertEquals(str1, str2.toUpperCase());
    }

    // we can use CsvSource with more than 2 parameters
    //test contains methods
    /*
    task for students write one line code
    *********
        if I want to test:
            java contains a  --> asserTrue
            junit contains u --> assertTrue
            hello contains a --> assertFalse
         how would you test this?

     */
    @ParameterizedTest
    @CsvSource(value={
            "true, java, a",
            "true, junit, u",
            "false, hello, a"})

    void testContains(boolean b1, String s1, String s2){
        assertEquals(b1, s1.contains(s2));
    }
}
