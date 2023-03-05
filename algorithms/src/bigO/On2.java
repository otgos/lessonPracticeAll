package bigO;

public class On2 {
    public static void main(String[] args) {
        //add each element to other element, including itself
        int count = 0;
        int[] arr = {1,5,7};
        for(int i =0; i<arr.length;i++){
            for(int j=0; j<arr.length; j++){
                System.out.println(arr[i]+arr[j]);
                count++;
            }
        }
        System.out.println(count);


    }
}
