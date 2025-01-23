import java.util.Scanner;

public class Abundant {
    public static void main(String[] args) {
        // Step 1: Get an integer input from the user
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter an integer: ");
        int number = scanner.nextInt();

        // Step 2: Create a variable to store the sum of divisors and initialize it to 0
        int sum = 0;

        // Step 3: Run a for loop from i = 1 to i < number
        for (int i = 1; i < number; i++) {
            // Step 4: Check if the number is divisible by i
            if (number % i == 0) {
                // Step 5: If true, add i to the sum
                sum += i;
            }
        }

        // Step 6: Check if the sum is greater than the number
        if (sum > number) {
            System.out.println(number + " is an Abundant Number.");
        } else {
            System.out.println(number + " is not an Abundant Number.");
        }

        scanner.close(); // Close the scanner to release resources
    }
}

