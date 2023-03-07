package quickSort;

import bubbleSort.BubbleSort;

import java.util.Arrays;

public class QuickSortRunner {
    public static void main(String[] args) {
        int [] arr = {4, 3, 2, 33, 1};

        System.out.println("======= Before Quick Sort ======");
        System.out.println(Arrays.toString(arr));
        QuickSort.quickSort1(arr, 0, arr.length-1);
        System.out.println("======= After Quick Sort ======");
        System.out.println(Arrays.toString(arr));
    }
}
