import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class P3 {
    public static void main(String[] args) {
        // Get the current date
        LocalDate currentDate = LocalDate.now();

        // Define the DateTimeFormatter for different formats
        DateTimeFormatter formatter1 = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        DateTimeFormatter formatter2 = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        DateTimeFormatter formatter3 = DateTimeFormatter.ofPattern("EEE, MMM dd, yyyy");

        // Display the current date in different formats
        System.out.println("Current date in dd/MM/yyyy format: " + currentDate.format(formatter1));
        System.out.println("Current date in yyyy-MM-dd format: " + currentDate.format(formatter2));
        System.out.println("Current date in EEE, MMM dd, yyyy format: " + currentDate.format(formatter3));
    }
}

