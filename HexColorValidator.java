import java.util.Scanner;

public class HexColorValidator {
    // Regular expression for a valid hex color code
    private static final String HEX_COLOR_REGEX = "^#[0-9A-Fa-f]{6}$";

    public static boolean isValidHexColor(String hexColor) {
        return hexColor.matches(HEX_COLOR_REGEX);
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter a hex color code to validate: ");
        String hexColor = scanner.nextLine();

        if (isValidHexColor(hexColor)) {
            System.out.println("Valid hex color code.");
        } else {
            System.out.println("Invalid hex color code.");
        }

        scanner.close();
    }
}
