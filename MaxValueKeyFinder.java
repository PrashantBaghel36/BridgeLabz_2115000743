// Find the Key with the Highest Value
// Given a Map<String, Integer>, find the key with the maximum value.
// Example:
// Input: {A=10, B=20, C=15} → Output: B.



import java.util.Map;
import java.util.HashMap;

public class MaxValueKeyFinder {
    public static String findMaxKey(Map<String, Integer> map) {
        String maxKey = null;
        int maxValue = Integer.MIN_VALUE;

        for (Map.Entry<String, Integer> entry : map.entrySet()) {
            if (entry.getValue() > maxValue) {
                maxValue = entry.getValue();
                maxKey = entry.getKey();
            }
        }
        return maxKey;
    }

    public static void main(String[] args) {
        Map<String, Integer> map = new HashMap<>();
        map.put("A", 10);
        map.put("B", 20);
        map.put("C", 15);

        System.out.println(findMaxKey(map));
    }
}
