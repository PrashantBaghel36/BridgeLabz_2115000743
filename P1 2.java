import java.util.Scanner;
import java.util.Random;

public class P1 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Random random = new Random();
        
        int low = 1, high = 100;
        boolean guessedCorrectly = false;
        
        System.out.println("Think of a number between 1 and 100.");
        System.out.println("I will try to guess it!");
        
        while (!guessedCorrectly) {
            int guess = generateGuess(low, high, random);
            System.out.println("Is your number " + guess + "? (Enter 'h' if too high, 'l' if too low, 'c' if correct):");
            
            char response = scanner.next().charAt(0);
            
            if (response == 'c') {
                System.out.println("Hooray! I guessed your number correctly!");
                guessedCorrectly = true;
            } else if (response == 'h') {
                high = guess - 1;
            } else if (response == 'l') {
                low = guess + 1;
            } else {
                System.out.println("Invalid input. Please enter 'h', 'l', or 'c'.");
            }
        }
        
        scanner.close();
    }
    
    private static int generateGuess(int low, int high, Random random) {
        return low + random.nextInt(high - low + 1);
    }
}

