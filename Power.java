import java.util.Scanner;

public class Power {
    public static void main(String[] args) {
        // Create a scanner object for user input
        Scanner scanner = new Scanner(System.in);
        
        // Get integer input for number and power
        System.out.print("Enter the base number: ");
        int number = scanner.nextInt();
        System.out.print("Enter the power: ");
        int power = scanner.nextInt();
        
        // Initialize result variable
        int result = 1;
        
        // Loop to calculate power
        for (int i = 1; i <= power; i++) {
            result *= number;
        }
        
        // Print the result
        System.out.println(number + " raised to the power of " + power + " is: " + result);
        
        // Close the scanner
        scanner.close();
    }
}

