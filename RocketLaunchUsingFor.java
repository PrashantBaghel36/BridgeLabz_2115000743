import java.util.Scanner;
public class RocketLaunchUsingFor {
public static void main(String[] args) {
Scanner scanner = new Scanner(System.in);
System.out.print("Enter the starting number for the countdown: ");
int counter = scanner.nextInt();
for (int i = counter; i >= 1; i--) {
System.out.println(i);
}
System.out.println("Liftoff!");
}
}
