package dsaPractice;

public class q3 {

    public static void reverseArray(int arr[]) {
        int start = 0;
        int end = arr.length - 1;
        while (start < end) {
            int temp = arr[start];
            arr[start] = arr[end];
            arr[end] = temp;
            start++;
            end--;
        }
    }

    // Main method to test the reverseArray function
    public static void main(String[] args) {
        int arr[] = { 1, 2, 3, 4, 5 };

        System.out.println("Original array:");
        printArray(arr);

        reverseArray(arr);

        System.out.println("Reversed array:");
        printArray(arr);
    }

    // Helper method to print the array
    public static void printArray(int arr[]) {
        for (int num : arr) {
            System.out.print(num + " ");
        }
        System.out.println();
    }

}
