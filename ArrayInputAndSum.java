import java.util.Scanner;

public class ArrayInputAndSum {
    public static void main(String[] args) {
        // Create an array to store up to 10 elements of type double
        double[] numbers = new double[10];
        double total = 0.0; // Initialize the total to 0.0
        int index = 0; // Initialize the index for the array

        Scanner scanner = new Scanner(System.in);

        System.out.println("Enter numbers (up to 10). Enter 0 or a negative number to stop:");

        // Infinite loop for taking user inputs
        while (true) {
            System.out.print("Enter a number: ");
            double input = scanner.nextDouble();

            // Break the loop if the input is 0 or negative
            if (input <= 0) {
                break;
            }

            // Break the loop if the index reaches the maximum array size (10)
            if (index == 10) {
                System.out.println("Array is full. Stopping input.");
                break;
            }

            // Store the input in the array and increment the index
            numbers[index] = input;
            index++;
        }

        // Calculate the total using a for loop
        for (int i = 0; i < index; i++) {
            total += numbers[i];
        }

        // Display all entered numbers
        System.out.println("\nYou entered the following numbers:");
        for (int i = 0; i < index; i++) {
            System.out.println(numbers[i]);
        }

        // Display the total sum of the numbers
        System.out.println("\nThe total sum of the numbers is: " + total);

        scanner.close();
    }
}

