import java.util.Scanner;

public class UsernameValidator {
    // Regular expression for a valid username
    private static final String USERNAME_REGEX = "^[a-zA-Z][a-zA-Z0-9_]{4,14}$";

    public static boolean isValidUsername(String username) {
        return username.matches(USERNAME_REGEX);
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter a username to validate: ");
        String username = scanner.nextLine();

        if (isValidUsername(username)) {
            System.out.println("Valid username.");
        } else {
            System.out.println("Invalid username.");
        }

        scanner.close();
    }
}
