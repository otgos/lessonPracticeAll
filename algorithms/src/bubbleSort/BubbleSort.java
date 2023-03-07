package bubbleSort;

public class BubbleSort {
    public static void bubbleSort(int [] arr){
        boolean swapped = false; // not swapped
        do {
            swapped = false; //avoid infinitive loop
            for (int i =1; i< arr.length; i++){
                if(arr[i-1]> arr[i]){

                    int temp = arr[i];
                    arr[i] = arr[i-1];
                    arr[i-1] = temp;
                    swapped = true; // if any element is swapped we need to set to true,
                    // so that we can run one more time
                }
            }
        }while (swapped);
    }
}
