import java.util.Scanner;

public class P6 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        // Taking user input
        int number = getInput(scanner);
        
        // Calculating factorial
        long result = calculateFactorial(number);
        
        // Displaying result
        displayResult(number, result);
        
        scanner.close();
    }
    
    private static int getInput(Scanner scanner) {
        System.out.print("Enter a number: ");
        return scanner.nextInt();
    }
    
    private static long calculateFactorial(int num) {
        if (num == 0 || num == 1) {
            return 1;
        }
        return num * calculateFactorial(num - 1);
    }
    
    private static void displayResult(int number, long result) {
        System.out.println("The factorial of " + number + " is: " + result);
    }
}

