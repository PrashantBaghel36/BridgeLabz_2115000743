import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;

public class P2 {
    public static void main(String[] args) {
        // Define the DateTimeFormatter for reading and displaying the date
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");

        // Take date input from user
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter a date (yyyy-MM-dd): ");
        String inputDate = scanner.nextLine();

        // Parse the input date into LocalDate
        LocalDate date = LocalDate.parse(inputDate, formatter);

        // Add 7 days, 1 month, and 2 years
        LocalDate newDate = date.plusDays(7).plusMonths(1).plusYears(2);

        // Subtract 3 weeks from the new date
        newDate = newDate.minusWeeks(3);

        // Output the resulting date
        System.out.println("Resulting date: " + newDate.format(formatter));

        // Close the scanner
        scanner.close();
    }
}

