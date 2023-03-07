package bubbleSort;

import java.util.Arrays;
import java.util.Random;

public class BubbleSortRunner {
    public static void main(String[] args) {
        Random random = new Random();
        int [] numbers = new int[10];

        for(int i = 0; i < numbers.length; i++ ){
            numbers[i] = random.nextInt(1000);
        }

        int [] arr = {4, 3, 2};

        System.out.println("======= Before Bubble Sort ======");
        System.out.println(Arrays.toString(numbers));
        BubbleSort.bubbleSort(numbers);
        System.out.println("======= Af Bubble Sort ======");
        System.out.println(Arrays.toString(numbers));
    }
}
