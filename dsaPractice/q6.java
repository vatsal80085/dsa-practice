package dsaPractice;

public class q6 {
    public static boolean isSorted(int nums[]){
        for(int i=1; i<nums.length; i++){
            if(nums[i]<nums[i-1]){
                return false;
            }
        }
        return true;
    }
    public static void main(String[] args) {
        int[] arr1 = {1, 2, 3, 4, 5};
        System.out.println("Is arr1 sorted? " + isSorted(arr1)); // true

        int[] arr2 = {5, 3, 2, 1};
        System.out.println("Is arr2 sorted? " + isSorted(arr2)); // false

        int[] arr3 = {10};
        System.out.println("Is arr3 sorted? " + isSorted(arr3)); // true

        int[] arr4 = {};
        System.out.println("Is arr4 sorted? " + isSorted(arr4)); // true
    }
}
