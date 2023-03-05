package selectionSort;

public class SelectionSorting {
    public static void selectionSort(int[] arr) {

        for (int i = 0; i < arr.length - 1; i++) {
            int index = i; //to hold index of smaller number
            for (int j = i + 1; j < arr.length; j++) {
                if (arr[j] < arr[index]) {
                    index = j;//searching for lowest index
                }
            }
            //swap number with smaller number
            int smallerNumber = arr[index];
            arr[index] = arr[i];
            arr[i] = smallerNumber;
        }
    }

}
