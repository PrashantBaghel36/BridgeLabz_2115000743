import java.util.Scanner;

public class FizzBuzz {
    public static void main(String[] args) {
        // Create a Scanner object to get user input
        Scanner scanner = new Scanner(System.in);

        // Take input for the number
        System.out.print("Enter a positive integer: ");
        int number = scanner.nextInt();

        // Check if the number is positive
        if (number <= 0) {
            System.out.println("Please enter a positive integer.");
            scanner.close();
            return; // Exit the program
        }

        // Create a String array to store the results
        String[] results = new String[number + 1];

        // Loop from 0 to the number and fill the results array
        for (int i = 0; i <= number; i++) {
            if (i % 3 == 0 && i % 5 == 0) {
                results[i] = "FizzBuzz";
            } else if (i % 3 == 0) {
                results[i] = "Fizz";
            } else if (i % 5 == 0) {
                results[i] = "Buzz";
            } else {
                results[i] = Integer.toString(i); // Convert number to string
            }
        }

        // Loop again to display the results in the required format
        for (int i = 0; i <= number; i++) {
            System.out.println("Position " + (i) + " = " + results[i]);
        }

        // Close the scanner
        scanner.close();
    }
}

