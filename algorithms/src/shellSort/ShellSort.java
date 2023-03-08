package shellSort;

public class ShellSort {
    public static void shellSort(int [] arr){
        int insert;
        int moveItem; //element to change
        for (int gap = arr.length/2; gap>0; gap/=2){
            for(int next = gap; next< arr.length; next++){
                insert = arr[next];
                moveItem = next;
                while(moveItem>=gap && insert <arr[moveItem-gap]){
                    arr[moveItem] = arr[moveItem-gap];
                    moveItem= moveItem-gap;
                }
                arr[moveItem] = insert;
            }
        }
    }
}
