import java.util.Scanner;
public class Both_Sum {
public static void main(String[] args) {
Scanner scanner = new Scanner(System.in);
System.out.print("Enter a number: ");
int n = scanner.nextInt();
if (n < 0) {
System.out.println("The number is not a natural number.");
} else {
int sumFormula = n * (n + 1) / 2;
int sumWhileLoop = 0;
int counter = 1;
while (counter <= n) {
sumWhileLoop += counter;
counter++;
}
System.out.println("Sum using formula: " + sumFormula);
System.out.println("Sum using while loop: " + sumWhileLoop);
if (sumFormula == sumWhileLoop) {
System.out.println("Both computations are correct.");
} else {
System.out.println("The computations are incorrect.");
}
}
}
}

