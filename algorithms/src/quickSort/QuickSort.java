package quickSort;

public class QuickSort {
    // we divide method into two methods to make things easy and clear
    public static int parse(int[] arr, int low, int high){
        //make last element of array as pivot
        int pivot =  arr[high];
        int i = (low-1);
        //make first replacement in iteration
        for(int j = low; j<high; j++){
            if(arr[j]<=pivot){ // if there are equal element to pivot, it will be sent to left
                i++;
                int temp = arr[i];
                arr[i] = arr[j];
                arr[j] = temp;

            }
        }
        int temp = arr[i+1];
        arr[i+1] = arr[high];
        arr[high] = temp;
        return  i+1;
    }

    public static  void quickSort(int arr[], int low, int high){
        if(low<high){
            int pi = parse(arr, low, high);

            quickSort(arr, low, pi-1); //works recursively for the left side of pivot
            quickSort(arr, pi+1, high);//works recursively for the right side of pivot
        }
    }


    //**low and high index are used, because when we do partition, we need to call recursively for the
    //th sub arrays
    public static  void quickSort1(int [] array, int lowIndex, int highIndex){
        //**show this at the end
        if(lowIndex>=highIndex){ //if there is one element
            return;
        }
        int pivot = array[highIndex]; //since it is recursive algorthim, we cannot choose always the last element
        // it should be dynamics. we may be dealing with small portion of sub array

        //** now we need to do the partitioning of the array depending on the pivot
        //ignore pivot and select two pointers

        int leftPointer = lowIndex;
        int rightPointer = highIndex;

        while(leftPointer<rightPointer){
            while (array[leftPointer]<=pivot && leftPointer <rightPointer){
                leftPointer++;
            }
            while (array[rightPointer]>=pivot && leftPointer <rightPointer) {
                rightPointer --;
            }
            swap(array, leftPointer, rightPointer);
        }
        swap(array, leftPointer, highIndex);

        quickSort1(array, lowIndex, leftPointer-1);
        quickSort1(array, leftPointer+1, highIndex);
    }
    private static void swap(int [] array, int index1, int index2){
        int temp = array[index1];
        array[index1] = array[index2];
        array[index2] = temp;
    }
}
