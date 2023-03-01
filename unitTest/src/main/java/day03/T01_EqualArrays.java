package day03;

import java.util.Arrays;

public class T01_EqualArrays {
    //are arrays equal?
    //{2, 4, 5} vs {5, 2, 4}

    public static  boolean compareArraysEqual(Object[] a, Object [] b){
        Arrays.sort(a);
        Arrays.sort(b);
        return Arrays.equals(a,b);

    }
}
