import java.util.Scanner;

public class DOperation {
    public static void main(String[] args) {
        
        Scanner scanner = new Scanner(System.in);

        
        System.out.print("Enter value for a: ");
        double a = scanner.nextDouble();
        
        System.out.print("Enter value for b: ");
        double b = scanner.nextDouble();
        
        System.out.print("Enter value for c: ");
        double c = scanner.nextDouble();

        
        double result1 = a + (b * c);  // First operation: a + b * c
        double result2 = (a * b) + c;  // Second operation: a * b + c
        double result3 = c + (a / b);  // Third operation: c + a / b
        double result4 = (a % b) + c;  // Fourth operation: a % b + c

        
        System.out.println("The results of Double Operations are:");
        System.out.println("a + b * c = " + result1);
        System.out.println("a * b + c = " + result2);
        System.out.println("c + a / b = " + result3);
        System.out.println("a % b + c = " + result4);

        
        
    }
}
