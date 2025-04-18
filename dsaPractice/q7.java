package dsaPractice;

public class q7 {
    public static int secondLargest(int[] nums){
        int largest=Integer.MIN_VALUE;
        int secondLargest= Integer.MIN_VALUE;
        for(int i=0;i<nums.length; i++){
            if(nums[i]>largest){
                secondLargest=largest;
                largest=nums[i];
            }
            if(nums[i]<largest && nums[i]>secondLargest){
                secondLargest=nums[i];
            }

        }
        if (secondLargest == Integer.MIN_VALUE) {
            throw new IllegalArgumentException("No valid second largest element found.");
        }

        return secondLargest;
    }

    public static void main(String[] args) {
        int[] arr1 = {10, 20, 4, 45, 99};
        System.out.println("Second Largest: " + secondLargest(arr1)); // 45

        int[] arr2 = {-5, -10, -1, -15};
        System.out.println("Second Largest: " + secondLargest(arr2)); // -5

        int[] arr3 = {7, 7, 7, 7};
        System.out.println("Second Largest: " + secondLargest(arr3)); // Exception: No valid second largest

        int[] arr4 = {1}; // Exception: Array must contain at least two elements
        System.out.println("Second Largest: " + secondLargest(arr4));
    }
}
