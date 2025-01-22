import java.util.Scanner;

public class Operation {
    public static void main(String[] args) {
        
        Scanner scanner = new Scanner(System.in);

       
        System.out.print("Enter value for a: ");
        int a = scanner.nextInt();
        
        System.out.print("Enter value for b: ");
        int b = scanner.nextInt();
        
        System.out.print("Enter value for c: ");
        int c = scanner.nextInt();

      
        int result1 = a + (b * c);  // First operation: a + b * c
        int result2 = (a * b) + c;  // Second operation: a * b + c
        int result3 = c + (a / b);  // Third operation: c + a / b
        int result4 = (a % b) + c;  // Fourth operation: a % b + c

        
        System.out.println("The results of Int Operations are:");
        System.out.println("a + b * c = " + result1);
        System.out.println("a * b + c = " + result2);
        System.out.println("c + a / b = " + result3);
        System.out.println("a % b + c = " + result4);

       
       
    }
}
