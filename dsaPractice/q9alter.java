package dsaPractice;

public class q9alter {
    public static int[] firstAndLastOcc(int arr[], int target){
        int first=0;
        int last=0;
        for(int i=0;i<arr.length; i++){
            if(arr[i]==target){
                last=i;
            }
        }
        for(int i=arr.length-1; i>=0; i--){
            if(arr[i]==target){
                first=i;
            }
        }
        return new int[]{first, last};
    }
    public static void main(String[] args) {
        int[] arr = {1, 2, 3, 4, 2, 5, 2, 6};
        int target = 2;

        int[] result = firstAndLastOcc(arr, target);

        System.out.println("First Occurrence: " + result[0]);
        System.out.println("Last Occurrence: " + result[1]);
    }
}
