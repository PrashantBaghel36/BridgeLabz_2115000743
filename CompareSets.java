// Check if Two Sets Are Equal
// Compare two sets and determine if they contain the same elements, regardless of order.
// Example:
// Set1: {1, 2, 3}, Set2: {3, 2, 1} → Output: true.

import java.util.HashSet;

public class CompareSets {
    public static boolean compareSets(HashSet<Integer> set1, HashSet<Integer> set2){
        if(set1.size()!=set2.size()) return false;
        // if(set2.containsAll(set1)) return true;
        for(int num : set1){
            if(!set2.contains(num)) return false;
        }
        return true;
    }
    public static void main(String[] args) {
        
        HashSet<Integer> set1 = new HashSet<>();
        HashSet<Integer> set2 = new HashSet<>();
        set1.add(1);
        set1.add(2);
        set1.add(3);
        set1.add(4);
        set2.add(1);
        set2.add(4);
        set2.add(2);
        set2.add(3);
        System.out.println(compareSets(set1, set2));

    }
}
