import java.util.Scanner;

public class Swap {
    public static void main(String[] args) {
       
        Scanner scanner = new Scanner(System.in);

        
        System.out.print("Enter the first number: ");
        int number1 = scanner.nextInt();

        
       System.out.print("Enter the second number: ");
        int number2 = scanner.nextInt();

        // Swap the two numbers using a temporary variable
        int temp = number1;
        number1 = number2;
        number2 = temp;

        // Output the swapped numbers
        System.out.println("The swapped numbers are " + number1 + " and " + number2);

        
        
    }
}
