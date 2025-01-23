import java.util.Scanner;

public class PrimeNumberChecker {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Input a number
        System.out.print("Enter a number to check if it is prime: ");
        int number = scanner.nextInt();

        // Check if the number is prime
        boolean isPrime = true;

        
        if (number <= 1) {
            isPrime = false;
        } else {
            // Check divisibility from 2 to number - 1
            for (int i = 2; i <= Math.sqrt(number); i++) {
                if (number % i == 0) {
                    isPrime = false; // Not a prime number
                    break; // Exit the loop
                }
            }
        }

       
        if (isPrime) {
            System.out.println(number + " is a prime number.");
        } else {
            System.out.println(number + " is not a prime number.");
        }

       
    }
}

