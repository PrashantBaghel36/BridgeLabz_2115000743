import java.util.Scanner;

public class NumberAnalysis {
    public static void main(String[] args) {
        // Define an integer array to store 5 elements
        int[] numbers = new int[5];
        Scanner scanner = new Scanner(System.in);

        // Get user input for 5 numbers
        System.out.println("Enter 5 numbers:");
        for (int i = 0; i < numbers.length; i++) {
            while (true) {
                try {
                    System.out.print("Enter number " + (i + 1) + ": ");
                    numbers[i] = Integer.parseInt(scanner.nextLine());
                    break;
                } catch (NumberFormatException e) {
                    System.out.println("Invalid input. Please enter an integer.");
                }
            }
        }

        // Loop through the array to check positivity, negativity, or zero
        for (int num : numbers) {
            if (num > 0) {
                if (num % 2 == 0) {
                    System.out.println("The number " + num + " is positive and even.");
                } else {
                    System.out.println("The number " + num + " is positive and odd.");
                }
            } else if (num < 0) {
                System.out.println("The number " + num + " is negative.");
            } else {
                System.out.println("The number is zero.");
            }
        }

        // Compare the first and last elements of the array
        int firstElement = numbers[0];
        int lastElement = numbers[numbers.length - 1];

        System.out.println("\nComparison of the first and last elements:");
        if (firstElement > lastElement) {
            System.out.println("The first element (" + firstElement + ") is greater than the last element (" + lastElement + ").");
        } else if (firstElement < lastElement) {
            System.out.println("The first element (" + firstElement + ") is less than the last element (" + lastElement + ").");
        } else {
            System.out.println("The first element (" + firstElement + ") is equal to the last element (" + lastElement + ").");
        }

        scanner.close();
    }
}

