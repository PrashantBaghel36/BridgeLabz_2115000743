import java.util.Scanner;

public class MeanHeight {
    public static void main(String[] args) {
        // Create a double array to store the heights of 11 players
        double[] heights = new double[11];
        double sum = 0.0; // Variable to store the sum of all heights

        Scanner scanner = new Scanner(System.in);

        // Get input values for the heights from the user
        System.out.println("Enter the heights of 11 football players:");
        for (int i = 0; i < heights.length; i++) {
            System.out.print("Enter height of player " + (i + 1) + ": ");
            heights[i] = scanner.nextDouble();
            sum += heights[i]; // Add each height to the sum
        }

        // Calculate the mean height
        double mean = sum / heights.length;

        // Display the mean height
        System.out.printf("\nThe mean height of the football team is: %.2f\n", mean);

        // Close the scanner
        scanner.close();
    }
}

