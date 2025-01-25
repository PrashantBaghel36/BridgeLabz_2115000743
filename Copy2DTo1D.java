import java.util.Scanner;

public class Copy2DTo1D {
    public static void main(String[] args) {
        // Create a Scanner object to get user input
        Scanner scanner = new Scanner(System.in);

        // Get the number of rows and columns from the user
        System.out.print("Enter the number of rows: ");
        int rows = scanner.nextInt();
        System.out.print("Enter the number of columns: ");
        int cols = scanner.nextInt();

        // Create a 2D array with the given rows and columns
        int[][] matrix = new int[rows][cols];

        // Take user input to fill the 2D array
        System.out.println("Enter the elements of the 2D array:");
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                System.out.print("Enter element at [" + i + "][" + j + "]: ");
                matrix[i][j] = scanner.nextInt();
            }
        }

        // Create a 1D array with size equal to rows * cols
        int[] oneDArray = new int[rows * cols];

        // Copy elements from the 2D array to the 1D array
        int index = 0; // Index for the 1D array
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                oneDArray[index++] = matrix[i][j]; // Copy each element and increment index
            }
        }

        // Display the 1D array
        System.out.println("\nThe 1D array after copying elements from the 2D array:");
        for (int i = 0; i < oneDArray.length; i++) {
            System.out.print(oneDArray[i] + " ");
        }

        // Close the scanner
        scanner.close();
    }
}

