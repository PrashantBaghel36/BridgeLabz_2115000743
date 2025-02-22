import java.util.Scanner;
import java.util.regex.Pattern;

public class CreditCardvalidator {

    private static final String CARD_REGEX = "^(4\\d{15}|5\\d{15})$";

    public static boolean isValidCreditCard(String cardNumber) {

        cardNumber = cardNumber.replaceAll("\\s", "");


        return Pattern.matches(CARD_REGEX, cardNumber);
    }

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter a credit card number to validate: ");
        String cardNumber = scanner.nextLine();

        if (isValidCreditCard(cardNumber)) {
            System.out.println("Valid credit card number.");
        } else {
            System.out.println("Invalid credit card number.");
        }
    }
}
