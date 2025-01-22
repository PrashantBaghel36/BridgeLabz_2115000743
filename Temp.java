import java.util.Scanner;

public class Temp{
    public static void main(String[] args) {
        // Create a Scanner object to take input from the user
        Scanner scanner = new Scanner(System.in);

        // Prompt user to enter the temperature in Fahrenheit
        System.out.print("Enter the temperature in Fahrenheit: ");
        double fahrenheit = scanner.nextDouble();

        // Convert Fahrenheit to Celsius using the formula: (°F − 32) × 5/9 = °C
        double celsiusResult = (fahrenheit - 32) * 5 / 9;

        // Output the result
        System.out.println(fahrenheit + " Fahrenheit is " + celsiusResult + " Celsius.");

        
        
    }
}
