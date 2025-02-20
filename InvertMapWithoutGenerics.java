// Invert a Map
// Invert a Map<K, V> to produce a Map<V, K>. Handle duplicate values by storing them in a list.
// Example:
// Input: {A=1, B=2, C=1} → Output: {1=[A, C], 2=[B]}.

import java.util.*;

public class InvertMapWithoutGenerics {
    public static Map<Integer, List<String>> invertMap(Map<String, Integer> map) {
        Map<Integer, List<String>> invertedMap = new HashMap<>();

        for (Map.Entry<String, Integer> entry : map.entrySet()) {
            Integer value = entry.getValue();
            String key = entry.getKey();

            if (!invertedMap.containsKey(value)) {
                invertedMap.put(value, new ArrayList<>());
            }
            invertedMap.get(value).add(key);
        }
        return invertedMap;
    }

    public static void main(String[] args) {
        Map<String, Integer> map = new HashMap<>();
        map.put("A", 1);
        map.put("B", 2);
        map.put("C", 1);

        System.out.println(invertMap(map));
    }
}
