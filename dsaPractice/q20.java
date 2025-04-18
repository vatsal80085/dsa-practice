package dsaPractice;

public class q20 {
    public static void moveZeroes(int[] arr){
        int[] temp= new int[arr.length];
        int j=0;
        for(int i=0; i<arr.length; i++){
            if(arr[i]!=0){
                temp[j++]=arr[i];
            }
        }
        while(j<arr.length){
            temp[j++]=0;
        }
        for(int k=0; k<arr.length; k++){
            arr[k]=temp[k];
        }
    }
    public static void main(String[] args) {
        int[] arr = {0, 1, 0, 3, 12};
        moveZeroes(arr);

        // Print the result
        for (int num : arr) {
            System.out.print(num + " ");
        }
        System.out.println();
    }
}
