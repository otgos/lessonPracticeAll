import bubbleSort.BubbleSort;
import insertionSort.InsertionSort;
import mergeSort.MergeSort;

import quickSort.QuickSort;
import selectionSort.SelectionSorting;
import shellSort.ShellSort;

import java.util.Arrays;
import java.util.Random;

public class WhichOneIsFaster {
    public static void main(String[] args) {

        int [] orderedArray = createOrderedList(1000);
        //** if num element is large
        int [] unOrderedArray = createRandomArray(10000);
        int[] unOrderedArray2 = Arrays.copyOf(unOrderedArray, unOrderedArray.length);
        int[] unOrderedArray3 = Arrays.copyOf(unOrderedArray, unOrderedArray.length);
        int[] unOrderedArray4 = Arrays.copyOf(unOrderedArray, unOrderedArray.length);
        int[] unOrderedArray5 = Arrays.copyOf(unOrderedArray, unOrderedArray.length);
        int[] unOrderedArray6 = Arrays.copyOf(unOrderedArray, unOrderedArray.length);
        int[] unOrderedArray7 = Arrays.copyOf(unOrderedArray, unOrderedArray.length);



        long startTime;
        long endTime;
        double estimatedTime;

        //insertion Sort
        startTime=System.currentTimeMillis();
        InsertionSort.sortInsertion(unOrderedArray);
        endTime = System.currentTimeMillis();
        estimatedTime = (double) (endTime -startTime)/1000;
        System.out.println("Insertion Sort = "+estimatedTime);


        //selection Sort
        startTime=System.currentTimeMillis();
        SelectionSorting.selectionSort(unOrderedArray2);
        endTime = System.currentTimeMillis();
        estimatedTime = (double) (endTime -startTime)/1000;
        System.out.println("Selection Sort = "+estimatedTime);

        //Bubble Sort
        startTime=System.currentTimeMillis();
        BubbleSort.bubbleSort(unOrderedArray3);
        endTime = System.currentTimeMillis();
        estimatedTime = (double) (endTime -startTime)/1000;
        System.out.println("Bubble Sort = "+estimatedTime);

        //Quick Sort
        startTime=System.currentTimeMillis();
        QuickSort.quickSort(unOrderedArray4, 0, unOrderedArray4.length-1);
        endTime = System.currentTimeMillis();
        estimatedTime = (double) (endTime -startTime)/1000;
        System.out.println("Quick Sort = "+estimatedTime);

        //Merge Sort
        startTime=System.currentTimeMillis();
        MergeSort.mergeSort(unOrderedArray5);
        endTime = System.currentTimeMillis();
        estimatedTime = (double) (endTime -startTime)/1000;
        System.out.println("Merge Sort = "+estimatedTime);

        //Shell Sort
        startTime=System.currentTimeMillis();
        ShellSort.shellSort(unOrderedArray6);
        endTime = System.currentTimeMillis();
        estimatedTime = (double) (endTime -startTime)/1000;
        System.out.println("Shell Sort = "+estimatedTime);

        //Arrays Sort
        startTime=System.currentTimeMillis();
        Arrays.sort(unOrderedArray7);
        endTime = System.currentTimeMillis();
        estimatedTime = (double) (endTime -startTime)/1000;
        System.out.println("Arrays Sort = "+estimatedTime);



    }

    public static int[] createRandomArray(int numOfElement){
        Random random = new Random();
        int [] numberList = new int[numOfElement];
        for(int i = 0; i<numberList.length; i++){
            numberList[i] = random.nextInt(10000);
        }
        return numberList;
    }
    public static int[] createOrderedList(int numElement){

        int [] arr = new int [numElement];
        for (int i =0; i<arr.length; i++){
            arr[i]=i;
        }
        return arr;
    }
}
