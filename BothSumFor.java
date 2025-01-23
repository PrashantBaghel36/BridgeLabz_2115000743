import java.util.Scanner;
public class BothSumFor {
public static void main(String[] args) {
Scanner scanner = new Scanner(System.in);
System.out.print("Enter a number: ");
int n = scanner.nextInt();
if (n < 0) {
System.out.println("The number is not a natural number.");
} else {
int sumFormula = n * (n + 1) / 2;
int sumForLoop = 0;
for (int i = 1; i <= n; i++) {
sumForLoop += i;
}
System.out.println("Sum using formula: " + sumFormula);
System.out.println("Sum using for loop: " + sumForLoop);
if (sumFormula == sumForLoop) {
System.out.println("Both computations are correct.");
} else {
System.out.println("The computations are incorrect.");
}
}
}
}
