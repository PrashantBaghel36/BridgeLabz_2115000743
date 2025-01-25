import java.util.Scanner;

public class FactorsOfNumber {
    public static void main(String[] args) {
        // Create a Scanner object for input
        Scanner scanner = new Scanner(System.in);

        // Take input for the number
        System.out.print("Enter a number: ");
        int number = scanner.nextInt();

        // Initialize maxFactor and the factors array
        int maxFactor = 10; // Initial array size
        int[] factors = new int[maxFactor];
        int index = 0; // To track the index of the array

        // Loop through numbers from 1 to the number to find factors
        for (int i = 1; i <= number; i++) {
            if (number % i == 0) {
                // If i is a factor, store it in the array
                if (index == maxFactor) {
                    // If the array is full, double the size of the array
                    maxFactor *= 2;
                    // Create a temporary array to store the existing factors
                    int[] temp = new int[maxFactor];
                    // Copy elements from factors array to temp
                    System.arraycopy(factors, 0, temp, 0, factors.length);
                    // Assign the temp array back to factors
                    factors = temp;
                }
                // Add the factor to the array and increment the index
                factors[index++] = i;
            }
        }

        // Display the factors of the number
        System.out.print("Factors of " + number + ": ");
        for (int i = 0; i < index; i++) {
            System.out.print(factors[i] + " ");
        }
        System.out.println();

        // Close the scanner
        scanner.close();
    }
}

