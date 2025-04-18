package dsaPractice;

import java.util.Arrays;

public class q10 {
    public static void sorting(int arr[]) {
        Arrays.sort(arr); // Sort the array in ascending order
    }

    public static void main(String[] args) {
        int[] arr = { 9, 5, 1, 7, 3 };

        System.out.println("Original array: " + Arrays.toString(arr));

        sorting(arr); // Call the sorting function

        System.out.println("Sorted array: " + Arrays.toString(arr));
    }
}
