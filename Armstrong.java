import java.util.Scanner;

public class Armstrong {
    public static void main(String[] args) {
        // Step 1: Get an integer input from the user
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter a number: ");
        int number = scanner.nextInt();

        // Step 2: Initialize sum to 0 and store the input number in originalNumber
        int sum = 0;
        int originalNumber = number;

        // Step 3: Use a while loop till the originalNumber is not equal to zero
        while (originalNumber != 0) {
            // Step 4: Find the remainder (last digit) using modulus operator
            int remainder = originalNumber % 10;

            // Step 5: Find the cube of the digit and add it to the sum
            sum += Math.pow(remainder, 3);

            // Step 6: Remove the last digit from originalNumber using integer division
            originalNumber /= 10;
        }

        // Step 7: Check if the number is equal to the sum of the cubes of its digits
        if (number == sum) {
            System.out.println(number + " is an Armstrong number.");
        } else {
            System.out.println(number + " is not an Armstrong number.");
        }

        scanner.close(); // Close the scanner to release resources
    }
}

