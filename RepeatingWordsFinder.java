import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class RepeatingWordsFinder {

    private static final String REPEATING_WORDS_REGEX = "\\b(\\w+)\\b(?:\\s+\\1\\b)+";

    public static void findRepeatingWords(String text) {
        Pattern pattern = Pattern.compile(REPEATING_WORDS_REGEX, Pattern.CASE_INSENSITIVE);
        Matcher matcher = pattern.matcher(text);

        while (matcher.find()) {
            System.out.print(matcher.group(1) + ", ");
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter a sentence to find repeating words: ");
        String text = scanner.nextLine();

        System.out.println("Repeating words:");
        findRepeatingWords(text);


    }
}

