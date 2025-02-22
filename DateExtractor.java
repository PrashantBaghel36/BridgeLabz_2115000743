
import java.util.Scanner;
        import java.util.regex.Matcher;
        import java.util.regex.Pattern;

public class DateExtractor {
    // Regular expression for extracting dates in dd/mm/yyyy format
    private static final String DATE_REGEX = "\\b(0[1-9]|[12][0-9]|3[01])/(0[1-9]|1[0-2])/\\d{4}\\b";

    public static void extractDates(String text) {
        Pattern pattern = Pattern.compile(DATE_REGEX);
        Matcher matcher = pattern.matcher(text);

        while (matcher.find()) {
            System.out.print(matcher.group() + ", ");
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter a text to extract dates from: ");
        String text = scanner.nextLine();

        System.out.println("Extracted dates:");
        extractDates(text);

        scanner.close();
    }
}
