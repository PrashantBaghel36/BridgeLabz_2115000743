import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ProgrammingLanguageExtractor {
    private static final String LANG_REGEX = "\\b(JavaScript|Java|Python|C\\+\\+|C#|Ruby|Swift|Go|Kotlin|PHP|TypeScript)\\b";

    public static void extractLanguages(String text) {
        Pattern pattern = Pattern.compile(LANG_REGEX);
        Matcher matcher = pattern.matcher(text);

        while (matcher.find()) {
            System.out.print(matcher.group() + ", ");
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter a text to extract programming languages from: ");
        String text = scanner.nextLine();

        System.out.println("Extracted programming languages:");
        extractLanguages(text);

        scanner.close();
    }
}
