package dsaPractice;

public class q4 {

    public static int reverseInteger(int x) {
        int reversed = 0;
        
        while (x != 0) {
            int digit = x % 10; // Extract the last digit

            // Check for integer overflow before updating reversed
            if (reversed > Integer.MAX_VALUE / 10 || reversed < Integer.MIN_VALUE / 10) {
                return 0; // Return 0 if overflow occurs
            }

            reversed = reversed * 10 + digit; // Build the reversed number
            x = x / 10; // Remove the last digit
        }

        return reversed;
    }

    public static void main(String[] args) {
        int number = 12345;
        System.out.println("Original number: " + number);
        System.out.println("Reversed number: " + reverseInteger(number));

        number = -9876;
        System.out.println("Original number: " + number);
        System.out.println("Reversed number: " + reverseInteger(number));
    }
}
