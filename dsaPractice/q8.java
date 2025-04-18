package dsaPractice;

public class q8 {
    public static int binarySearch(int[] nums, int target) {
        int left = 0;
        int right = nums.length - 1;

        while (left <= right) {
            int mid = left + (right - left) / 2; // Avoid potential overflow

            if (nums[mid] == target) {
                return mid; // Target found, return its index
            } else if (nums[mid] < target) {
                left = mid + 1; // Search in the right half
            } else {
                right = mid - 1; // Search in the left half
            }
        }

        return -1; // Target not found
    }

    public static void main(String[] args) {
        int[] arr = {2, 4, 6, 8, 10, 12, 14};

        System.out.println("Index of 8: " + binarySearch(arr, 8)); // 3
        System.out.println("Index of 5: " + binarySearch(arr, 5)); // -1 (Not found)
        System.out.println("Index of 2: " + binarySearch(arr, 2)); // 0
        System.out.println("Index of 14: " + binarySearch(arr, 14)); // 6
    }
}
