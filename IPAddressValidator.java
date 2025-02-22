import java.util.Scanner;
import java.util.regex.Pattern;

public class IPAddressValidator {

    private static final String IP_REGEX =
            "^(25[0-5]|2[0-4][0-9]|1[0-9]{2}|[1-9]?[0-9])\\." +
                    "(25[0-5]|2[0-4][0-9]|1[0-9]{2}|[1-9]?[0-9])\\." +
                    "(25[0-5]|2[0-4][0-9]|1[0-9]{2}|[1-9]?[0-9])\\." +
                    "(25[0-5]|2[0-4][0-9]|1[0-9]{2}|[1-9]?[0-9])$";


    public static boolean isValidIPAddress(String ip) {
        return Pattern.matches(IP_REGEX, ip);
    }

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter an IP address to validate: ");
        String ip = scanner.nextLine();

        if (isValidIPAddress(ip)) {
            System.out.println("Valid IP address.");
        } else {
            System.out.println("Invalid IP address.");
        }

        scanner.close();
    }
}
