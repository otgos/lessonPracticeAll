package insertionSort;

import java.util.Arrays;

public class InsertionSortRunner {
    public static void main( String args[] ) {
        int [] arr = {9, 7, 6, 15, 17, 5, 10, 11};
        System.out.println("======= Before sorting ======");
        System.out.println(Arrays.toString(arr));

        InsertionSort.sortInsertion(arr);

        System.out.println("======= After sorting ======");
        for(int i=0;i<arr.length;++i){
            System.out.print(arr[i] + " ");
        }
    }
}
