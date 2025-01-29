import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;

public class P4 {
    public static void main(String[] args) {
        // Define the DateTimeFormatter for parsing date input
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");

        // Take the two date inputs from the user
        Scanner scanner = new Scanner(System.in);
        
        System.out.print("Enter the first date (yyyy-MM-dd): ");
        String firstDateInput = scanner.nextLine();
        System.out.print("Enter the second date (yyyy-MM-dd): ");
        String secondDateInput = scanner.nextLine();

        // Parse the input strings into LocalDate objects
        LocalDate firstDate = LocalDate.parse(firstDateInput, formatter);
        LocalDate secondDate = LocalDate.parse(secondDateInput, formatter);

        // Compare the two dates
        if (firstDate.isBefore(secondDate)) {
            System.out.println("The first date is before the second date.");
        } else if (firstDate.isAfter(secondDate)) {
            System.out.println("The first date is after the second date.");
        } else if (firstDate.isEqual(secondDate)) {
            System.out.println("The first date is the same as the second date.");
        }

        // Close the scanner
        scanner.close();
    }
}

