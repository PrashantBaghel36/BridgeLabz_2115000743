import java.util.Scanner;

public class Multiple {
    public static void main(String[] args) {
        // Create a scanner object for user input
        Scanner scanner = new Scanner(System.in);
        
        // Get integer input for the number
        System.out.print("Enter a number: ");
        int number = scanner.nextInt();
        
        // Loop backward from 100 to 1
        System.out.println("Multiples of " + number + " below 100 are:");
        for (int i = 100; i >= 1; i--) {
            if (i % number == 0) { // Check if i is a multiple of number
                System.out.println(i);
            }
        }
        
        // Close the scanner
        scanner.close();
    }
}

