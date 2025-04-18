package dsaPractice;

public class q1alter {
    public static int[] findMinMax(int[] nums){
        int max = nums[0];
        int min = nums[0];
        for(int num: nums){
            if(num>max){
                max=num;
            }
            if(num<min){
                min=num;
            }
        }
        return new int[]{max,min};
    } 

    public static void main(String[] args) {
        int[] nums = {3, 1, 4, 1, 5, 9, 2, 6};
        int[] result = findMinMax(nums);
        System.out.println("Max: " + result[0] + ", Min: " + result[1]);
    }
}
