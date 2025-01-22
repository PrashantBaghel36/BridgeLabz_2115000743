import java.util.Scanner;

public class Calculator {
    public static void main(String[] args) {
       
        Scanner input = new Scanner(System.in);
        
        
        System.out.print("Enter the first number: ");
        double number1 = input.nextDouble();
        
        System.out.print("Enter the second number: ");
        double number2 = input.nextDouble();
        
       
        double addition = number1 + number2;
        double subtraction = number1 - number2;
        double multiplication = number1 * number2;
        double division = 0;
        
        
        if (number2 != 0) {
            division = number1 / number2;
        } else {
            System.out.println("Division by zero is not allowed.");
        }

       
        System.out.println("Addition: " + addition);
        System.out.println("Subtraction: " + subtraction);
        System.out.println("Multiplication: " + multiplication);
        if (number2 != 0) {
            System.out.println("Division: " + division);
        }
        
        
            }
}
