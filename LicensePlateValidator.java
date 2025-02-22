import java.util.*;
public class LicensePlateValidator {
    // Regular expression for a valid license plate
    private static final String LICENSE_PLATE_REGEX = "^[A-Z]{2}d{4}$";

    public static boolean isValidLicensePlate(String licensePlate) {
        return licensePlate.matches(LICENSE_PLATE_REGEX);
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter a license plate number to validate: ");
        String licensePlate = scanner.nextLine();

        if (isValidLicensePlate(licensePlate)) {
            System.out.println("Valid license plate number.");
        } else {
            System.out.println("Invalid license plate number.");
        }

        scanner.close();
    }
}
