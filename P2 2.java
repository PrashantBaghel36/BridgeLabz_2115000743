import java.util.Scanner;

public class P2 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        // Taking user input
        int num1 = getInput(scanner, "Enter first number: ");
        int num2 = getInput(scanner, "Enter second number: ");
        int num3 = getInput(scanner, "Enter third number: ");
        
        // Finding maximum number
        int max = findMax(num1, num2, num3);
        
        // Displaying result
        System.out.println("The maximum number is: " + max);
        
        scanner.close();
    }
    
    private static int getInput(Scanner scanner, String message) {
        System.out.print(message);
        return scanner.nextInt();
    }
    
    private static int findMax(int a, int b, int c) {
        return Math.max(a, Math.max(b, c));
    }
}

