import java.util.Scanner;

public class SpaceReducer {
    public static String reduceSpaces(String text) {
        return text.replaceAll("\\s+", " ").trim();
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter text with multiple spaces: ");
        String text = scanner.nextLine();

        System.out.println("Processed text:");
        System.out.println(reduceSpaces(text));

        scanner.close();
    }
}
