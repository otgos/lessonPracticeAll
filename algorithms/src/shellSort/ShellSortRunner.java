package shellSort;

import java.util.Arrays;
import java.util.Random;

public class ShellSortRunner {
    public static void main(String[] args) {
        Random random = new Random();
        int [] numberList = new int[10];
        for(int i = 0; i<numberList.length; i++){
            numberList[i] = random.nextInt(100);
        }

        int[] arr = {4, 3, 1, 2};
        System.out.println("======= Before Quick Sort ======");
        System.out.println(Arrays.toString(numberList));
        System.out.println("======= After Quick Sort ======");
        ShellSort.shellSort(numberList);
        System.out.println(Arrays.toString(numberList));
    }
}
