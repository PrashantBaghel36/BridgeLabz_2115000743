import java.util.Scanner;

public class P4
 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        // Taking user input
        System.out.print("Enter the number of terms: ");
        int terms = scanner.nextInt();
        
        // Generating Fibonacci sequence
        generateFibonacci(terms);
        
        scanner.close();
    }
    
    private static void generateFibonacci(int terms) {
        int first = 0, second = 1;
        
        System.out.println("Fibonacci Sequence:");
        for (int i = 0; i < terms; i++) {
            System.out.print(first + " ");
            int next = first + second;
            first = second;
            second = next;
        }
        System.out.println();
    }
}

