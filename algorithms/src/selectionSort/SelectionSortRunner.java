package selectionSort;

public class SelectionSortRunner {
    public static void main(String[] args) {

        int[] arr1 = {7, 4, 5, 9, 8, 2, 1};
        System.out.println("Before Selection Sort");
        for(int i:arr1){
            System.out.print(i+" ");
        }
        System.out.println();

        SelectionSorting.selectionSort(arr1);//sorting array using selection sort

        System.out.println("After Selection Sort");
        for(int i:arr1){
            System.out.print(i+" ");
        }

    }
}
