import java.util.Scanner;
import java.util.regex.Pattern;

public class SSNValidator {

    private static final String SSN_REGEX = "^(\\d{3}-\\d{2}-\\d{4})$";

    public static boolean isValidSSN(String ssn) {
        return Pattern.matches(SSN_REGEX, ssn);
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter a Social Security Number (SSN) to validate: ");
        String ssn = scanner.nextLine();

        if (isValidSSN(ssn)) {
            System.out.println("✅ \"" + ssn + "\" is valid");
        } else {
            System.out.println("❌ \"" + ssn + "\" is invalid");
        }

        scanner.close();
    }
}
