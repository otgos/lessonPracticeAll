package mergeSort;

public class MergeSort {
    public static void mergeSort(int [] arr){
        int arrLength = arr.length;

        // if the length is less than 2 we cannot do anything, it is already sorted

        if(arrLength<2){
            return;
        }
        // we need to divide array
        int midIndex = arrLength/2;
        int [] leftHalf = new int [midIndex];
        //if there are odd elements, second half will be larger
        int [] rightHalf = new int [arrLength - midIndex];

        int i = 0;//** explain the benefit
        //we fill the left array
        for(i = 0; i< midIndex; i++){
            leftHalf[i] = arr[i];
        }
        // fill the rightHalf arr
        int j = midIndex;
        for(j = midIndex; j<arrLength; j++){
            //new arr will start from 0
            rightHalf[j-midIndex] = arr[j];
        }

        //call recursively to divide the elements

        mergeSort(leftHalf);
        mergeSort(rightHalf);

        //call merge which sorted
        merge(arr, leftHalf,rightHalf);

    }
    //method to merge
    private static void merge(int [] arr, int[] leftHalf, int[] rightHalf){
        //find length of left and right elements
        int leftSize = leftHalf.length;
        int rightSize = rightHalf.length;

        // 3 elements to iterate through 3 arrays
        int i = 0;
        int j = 0;
        int k = 0;
        //continue any side run out of element
        while(i<leftSize && j<rightSize){
            if(leftHalf[i]<=rightHalf[j]){
                arr[k] = leftHalf[i];
                i++;
            }else {
                arr[k] = rightHalf[j];
                j++;
            }
            //either way we need to increment k
            k++;
        }

        //if any element left over from both sides
        while (i<leftSize){
            arr[k] = leftHalf[i];
            i++;
            k++;
        }

        while (j<rightSize){
            arr[k] = rightHalf[j];
            j++;
            k++;

        }

    }

}
