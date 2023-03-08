package mergeSort;

import java.util.Arrays;
import java.util.Random;

public class MergeSortRunner {
    public static void main(String[] args) {
        Random random = new Random();
        int [] numberList = new int[10];
        for(int i = 0; i<numberList.length; i++){
            numberList[i] = random.nextInt(1000000);
        }

        int[] arr = {4, 3, 1, 2};
        System.out.println("======= Before Quick Sort ======");
        System.out.println(Arrays.toString(numberList));
        System.out.println("======= After Quick Sort ======");
        MergeSort.mergeSort(numberList);
        System.out.println(Arrays.toString(numberList));
    }
}
