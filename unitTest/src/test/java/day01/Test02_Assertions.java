package day01;

import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.*;

public class Test02_Assertions {
    @Test
    void testToFindMin(){
        //so far we learned assertEquals()
        //assertEquals(14, Math.min(14, 17));
        //** sometimes I need to ask: assertTrue() or assertFalse()?
        //assertTrue(true) ==>pass
       // assertTrue(11.5 == Math.min(16.5, 14.5));
        //assertFalse(false)==>pass
        assertFalse(Math.max(13, 34) != 34);
    }

    @Test
    void testArray(){
        String str = "Unit testing improves code quality";
        String[] actualArray = str.split(" ");
        String [] expectedArray = {"Unit", "testing", "improves", "code", "quality"};
        assertTrue(Arrays.equals(expectedArray, actualArray));
    }
}
