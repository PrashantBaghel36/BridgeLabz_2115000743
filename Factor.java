import java.util.Scanner;

public class Factor {
    public static void main(String[] args) {
    
        Scanner scanner = new Scanner(System.in);
        
        
        System.out.print("Enter a number: ");
        int number = scanner.nextInt();
        
        
        System.out.println("Factors of " + number + " are:");
        for (int i = 1; i < number; i++) {
            if (number % i == 0) { // Check if i is a factor
                System.out.println(i);
            }
        }
        
        
    }
}

