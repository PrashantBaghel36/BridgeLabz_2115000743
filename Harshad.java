import java.util.Scanner;

public class Harshad {
    public static void main(String[] args) {
        // Step 1: Get an integer input from the user
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter an integer: ");
        int number = scanner.nextInt();

        // Step 2: Create a variable to store the sum of digits and initialize it to 0
        int sum = 0;

        // Step 3: Store the original number to use it later
        int originalNumber = number;

        // Step 4: Create a while loop to access each digit of the number
        while (number != 0) {
            // Step 5: Extract the last digit of the number
            int digit = number % 10;

            // Step 6: Add the digit to the sum
            sum += digit;

            // Step 7: Remove the last digit from the number
            number /= 10;
        }

        // Step 8: Check if the original number is perfectly divisible by the sum of its digits
        if (originalNumber % sum == 0) {
            System.out.println(originalNumber + " is a Harshad Number.");
        } else {
            System.out.println(originalNumber + " is not a Harshad Number.");
        }

        scanner.close(); // Close the scanner to release resources
    }
}

