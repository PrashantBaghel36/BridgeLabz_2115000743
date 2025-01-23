import java.util.Scanner;

public class GreatestFactor {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Input the number
        System.out.print("Enter an integer: ");
        int number = scanner.nextInt();

        // Define the greatest factor variable and initialize it to 1
        int greatestFactor = 1;

        // Loop from number - 1 down to 1
        for (int i = number - 1; i >= 1; i--) {
            if (number % i == 0) { // Check if 'i' is a factor
                greatestFactor = i; // Assign i to greatestFactor
                break; // Break the loop as we found the greatest factor
            }
        }

        // Display the greatest factor
        System.out.println("The greatest factor of " + number + " (besides itself) is: " + greatestFactor);

        
    }
}

