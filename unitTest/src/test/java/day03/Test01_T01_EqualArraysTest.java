package day03;



import org.junit.jupiter.params.*;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.*;

class Test01_T01_EqualArraysTest {

    @ParameterizedTest
    @MethodSource("arrayArguments")
    void testCompareArrays(boolean result, Object[] x, Object[] y) {
        assertEquals(result, T01_EqualArrays.compareArraysEqual(x, y));
    }



    static Stream<Arguments> arrayArguments(){

        Integer[] a1 = {1, 4, 5, 2};
        Integer[] a2 = {4, 1, 2, 5};

        String[] s1 ={"j", "v", "a", "a"};
        String[] s2 ={"a", "j", "a", "v"};

        Double [] d1 = {1.3, 4.4, 3.3};
        Double [] d2 = {3.3, 1.3, 4.4};

        return Stream.of(Arguments.of(true, a1, a2),
                Arguments.of(true, s1, s2),
                Arguments.of(true, d1, d2));
    }


}