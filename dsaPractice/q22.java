package dsaPractice;

public class q22 {
    public static int removeDuplicateInSortedArray(int[] arr){
        if(arr.length==0){
            return 0;
        }
        int k=1;
        for(int i=1; i<arr.length; i++){
            if(arr[i]!=arr[i-1]){
                arr[k]=arr[i];
                k++;
            }
        }
        return k;
    }
    public static void main(String[] args) {
        int[] arr = {1, 1, 2, 2, 3, 4, 4, 5};

        int uniqueCount = removeDuplicateInSortedArray(arr);

        System.out.println("Number of unique elements: " + uniqueCount);
        System.out.print("Modified array: ");
        for (int i = 0; i < uniqueCount; i++) {
            System.out.print(arr[i] + " ");
        }
        System.out.println();
    }
}
