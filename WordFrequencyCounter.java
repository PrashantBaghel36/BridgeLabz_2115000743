// Word Frequency Counter
// Read a text file and count the frequency of each word using a HashMap. Ignore case and punctuation.
// Example:
// Input: "Hello world, hello Java!" → Output: {hello=2, world=1, java=1}



import java.io.*;
import java.util.*;

public class WordFrequencyCounter {
    public static void main(String[] args) throws IOException {
        String text = "Hello world, hello Java!";
        Map<String, Integer> wordCount = countWordFrequency(text);
        System.out.println(wordCount);
    }

    public static Map<String, Integer> countWordFrequency(String text) {
        Map<String, Integer> frequencyMap = new HashMap<>();
        text = text.replaceAll("[^a-zA-Z ]", "").toLowerCase();
        String[] words = text.split("\\s+");
        
        for (String word : words) {
            frequencyMap.put(word, frequencyMap.getOrDefault(word, 0) + 1);
        }
        
        return frequencyMap;
    }
}