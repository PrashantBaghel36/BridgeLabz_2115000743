import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class CurrencyExtractor {

    private static final String CURRENCY_REGEX = "\\$?\\d+\\.\\d{2}";

    public static void extractCurrencyValues(String text) {
        Pattern pattern = Pattern.compile(CURRENCY_REGEX);
        Matcher matcher = pattern.matcher(text);

        while (matcher.find()) {
            System.out.print(matcher.group() + ", ");
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter a text to extract currency values from: ");
        String text = scanner.nextLine();

        System.out.println("Extracted currency values:");
        extractCurrencyValues(text);

    }
}
