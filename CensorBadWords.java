import java.util.Scanner;

public class CensorBadWords {
    private static final String[] BAD_WORDS = {"damn", "stupid"};

    public static String censorText(String text) {
        for (String badWord : BAD_WORDS) {
            text = text.replaceAll("\\b" + badWord + "\\b", "****");
        }
        return text;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter a sentence: ");
        String text = scanner.nextLine();

        System.out.println("Censored text:");
        System.out.println(censorText(text));

        scanner.close();
    }
}
