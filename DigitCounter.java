import java.util.Scanner;

public class DigitCounter {
    public static void main(String[] args) {
        // Step 1: Get an integer input from the user
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter an integer: ");
        int number = scanner.nextInt();

        // Step 2: Create an integer variable 'count' with initial value 0
        int count = 0;

        // Step 3: Use a loop to iterate until the number is not equal to 0
        while (number != 0) {
            // Step 4: Remove the last digit from the number
            number /= 10; // Integer division removes the last digit
            
            // Step 5: Increase count by 1 in each iteration
            count++;
        }

        // Step 6: Display the count to show the number of digits
        System.out.println("The number of digits is: " + count);

        scanner.close(); // Close the scanner to release resources
    }
}

