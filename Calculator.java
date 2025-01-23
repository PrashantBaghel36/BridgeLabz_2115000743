import java.util.Scanner;

public class Calculator {
    public static void main(String[] args) {
        // Create a Scanner object for user input
        Scanner scanner = new Scanner(System.in);

        // Step 1: Declare variables for numbers and operator
        double first, second;
        String op;

        // Step 2: Get input for the first number, second number, and operator
        System.out.print("Enter the first number: ");
        first = scanner.nextDouble();

        System.out.print("Enter the second number: ");
        second = scanner.nextDouble();

        System.out.print("Enter an operator (+, -, *, /): ");
        op = scanner.next();

        // Step 3: Perform calculation based on the operator
        switch (op) {
            case "+":
                System.out.println("Result: " + (first + second));
                break;
            case "-":
                System.out.println("Result: " + (first - second));
                break;
            case "*":
                System.out.println("Result: " + (first * second));
                break;
            case "/":
                // Handle division separately to avoid dividing by zero
                if (second != 0) {
                    System.out.println("Result: " + (first / second));
                } else {
                    System.out.println("Error: Division by zero is not allowed.");
                }
                break;
            default:
                // Handle invalid operators
                System.out.println("Invalid operator. Please use one of +, -, *, /.");
        }

        // Close the scanner
        scanner.close();
    }
}

