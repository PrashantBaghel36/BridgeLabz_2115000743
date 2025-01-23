import java.util.Scanner;
public class SumUntilZero {
public static void main(String[] args) {
Scanner scanner = new Scanner(System.in);
double total = 0.0;
double userInput;
do {
System.out.print("Enter a number (0 to stop): ");
userInput = scanner.nextDouble();
total += userInput;
} while (userInput != 0);
System.out.println("The total sum is: " + total);
}
}
