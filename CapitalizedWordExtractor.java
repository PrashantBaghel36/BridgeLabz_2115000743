import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class CapitalizedWordExtractor {
    // Regular expression for extracting capitalized words
    private static final String CAPITALIZED_WORD_REGEX = "\\b[A-Z][a-z]*\\b";

    public static void extractCapitalizedWords(String text) {
        Pattern pattern = Pattern.compile(CAPITALIZED_WORD_REGEX);
        Matcher matcher = pattern.matcher(text);

        while (matcher.find()) {
            System.out.print(matcher.group() + ", ");
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter a sentence to extract capitalized words from: ");
        String text = scanner.nextLine();

        System.out.println("Extracted capitalized words:");
        extractCapitalizedWords(text);

        scanner.close();
    }
}
