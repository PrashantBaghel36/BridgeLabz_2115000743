import java.util.Scanner;

public class LongestWord {
    public static String findLongestWord(String sentence) {
        String[] words = sentence.split("\\s+"); // Split by whitespace
        String longestWord = "";
        
        for (String word : words) {
            // Remove punctuation
            word = word.replaceAll("[^a-zA-Z]", "");
            if (word.length() > longestWord.length()) {
                longestWord = word;
            }
        }
        
        return longestWord;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter a sentence: ");
        String sentence = scanner.nextLine();
        
        String longestWord = findLongestWord(sentence);
        System.out.println("Longest word: " + longestWord);
        
        scanner.close();
    }
}

