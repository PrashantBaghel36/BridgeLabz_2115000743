import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class LinkExtractor {
    // Improved regular expression for extracting URLs
    private static final String URL_REGEX = "\\bhttps?://[a-zA-Z0-9.-]+(?:\\.[a-zA-Z]{2,})(\\S*)?\\b";

    public static void extractLinks(String text) {
        Pattern pattern = Pattern.compile(URL_REGEX);
        Matcher matcher = pattern.matcher(text);
        boolean foundLink = false;

        while (matcher.find()) {
            System.out.println(matcher.group());
            foundLink = true;
        }

        if (!foundLink) {
            System.out.println("No links found.");
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter text to extract links from: ");
        String text = scanner.nextLine();
        System.out.println("Extracted links:");
        extractLinks(text);
        scanner.close();
    }
}
