package day01;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertThrows;

public class Test06_DisplayName {
    //method name should be understandable, if it is long?
    @DisplayName("Exception if Integer.parseInt() is not a integer")
    @Test
    void testException(){
        String str = "Hello";
        assertThrows(NumberFormatException.class, ()->{
            Integer.parseInt(str);
        });

    }
}
