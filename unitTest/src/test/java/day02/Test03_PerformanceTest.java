package day02;

import org.junit.jupiter.api.Test;

import java.time.Duration;
import java.util.stream.IntStream;

import static org.junit.jupiter.api.Assertions.assertTimeout;

public class Test03_PerformanceTest {
    //** suppose we have an array with 10000s of elements,
    // and we want to test the methods with that array
    //like sorting.. so the output is not important, but
    // if we are getting things done in limited time

    //** did you try leetcode?? you will see similar things
    // for these sites, it requires expected result in limited time..

    //test a method performance which will print some integer on screen
    @Test
    void testPrintPerformance(){
        assertTimeout(Duration.ofSeconds(3),
                //int stream which has integers 1-10000
                ()-> IntStream.rangeClosed(1, 100000).forEach(
                        System.out::println
                ));
    }
    //where can we write this method?

    @Test
    void testPerformance(){
        assertTimeout(Duration.ofSeconds(1),
                ()->IntStream.rangeClosed(1, 50000).reduce((x,y)->Math.addExact(x, y)));
    }
}
