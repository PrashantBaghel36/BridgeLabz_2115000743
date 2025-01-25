import java.util.Scanner;

public class VotingEligibility {
    public static void main(String[] args) {
        // Define an array to store the ages of 10 students
        int[] ages = new int[10];
        Scanner scanner = new Scanner(System.in);

        // Take input for ages of 10 students
        System.out.println("Enter the ages of 10 students:");
        for (int i = 0; i < ages.length; i++) {
            System.out.print("Enter age for student " + (i + 1) + ": ");
            while (true) {
                try {
                    ages[i] = Integer.parseInt(scanner.nextLine());
                    break;
                } catch (NumberFormatException e) {
                    System.out.print("Invalid input. Please enter a valid integer for age: ");
                }
            }
        }

        // Loop through the array and check voting eligibility
        for (int age : ages) {
            if (age < 0) {
                System.out.println("Invalid age: " + age + ". Age cannot be negative.");
            } else if (age >= 18) {
                System.out.println("The student with the age " + age + " can vote.");
            } else {
                System.out.println("The student with the age " + age + " cannot vote.");
            }
        }

        scanner.close();
    }
}

