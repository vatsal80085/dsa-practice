package dsaPractice;

public class q9 {
    public static int[] searchRange(int[] nums, int target) {
        int[] result = {-1, -1}; // Default result if target not found

        // Find the first occurrence
        result[0] = findBound(nums, target, true);
        
        // Find the last occurrence
        result[1] = findBound(nums, target, false);
        
        return result;
    }

    // Helper function to find the first or last occurrence
    private static int findBound(int[] nums, int target, boolean isFirst) {
        int left = 0, right = nums.length - 1;
        int bound = -1;

        while (left <= right) {
            int mid = left + (right - left) / 2;

            if (nums[mid] == target) {
                bound = mid; // Record the position
                if (isFirst) {
                    right = mid - 1; // Search the left half for the first occurrence
                } else {
                    left = mid + 1; // Search the right half for the last occurrence
                }
            } else if (nums[mid] < target) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }

        return bound; // Return the found boundary (or -1 if not found)
    }

    public static void main(String[] args) {
        int[] arr = {5, 7, 7, 8, 8, 10};

        int[] result = searchRange(arr, 8);
        System.out.println("First and Last Position of 8: [" + result[0] + ", " + result[1] + "]");

        result = searchRange(arr, 6);
        System.out.println("First and Last Position of 6: [" + result[0] + ", " + result[1] + "]");

        result = searchRange(arr, 5);
        System.out.println("First and Last Position of 5: [" + result[0] + ", " + result[1] + "]");
    }
}
