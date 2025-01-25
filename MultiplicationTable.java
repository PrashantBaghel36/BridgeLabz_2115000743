import java.util.Scanner;

public class MultiplicationTable {
    public static void main(String[] args) {
        // Create a Scanner object for input
        Scanner scanner = new Scanner(System.in);

        // Get the integer input for the number
        System.out.print("Enter a number to generate its multiplication table: ");
        int number = scanner.nextInt();

        // Define an integer array to store results of the multiplication table
        int[] multiplicationTable = new int[10];

        // Populate the array with multiplication results
        for (int i = 1; i <= 10; i++) {
            multiplicationTable[i - 1] = number * i;
        }

        // Display the multiplication table
        System.out.println("\nMultiplication Table for " + number + ":");
        for (int i = 1; i <= 10; i++) {
            System.out.println(number + " * " + i + " = " + multiplicationTable[i - 1]);
        }

        // Close the scanner
        scanner.close();
    }
}

