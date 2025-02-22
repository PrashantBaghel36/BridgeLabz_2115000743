import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class EmailExtractor {
 static final String EMAIL_REGEX = "[a-zA-Z0-9._%+-]+@[a-zA-Z0-9.-]+\\.[a-zA-Z]{2,}";

    public static void extractEmails(String text) {
        Pattern pattern = Pattern.compile(EMAIL_REGEX);
        Matcher matcher = pattern.matcher(text);
        boolean foundEmail = false;

        while (matcher.find()) {
            System.out.println(matcher.group());
            foundEmail = true;
        }

        if (!foundEmail) {
            System.out.println("No email addresses found.");
        }
    }

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter text to extract emails from: ");
        String text = scanner.nextLine();

        System.out.println("Extracted email addresses:");
        extractEmails(text);

        scanner.close();
    }
}
