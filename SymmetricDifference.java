// Symmetric Difference
// Find the symmetric difference (elements present in either set but not in both) of two sets.
// Example:
// Set1: {1, 2, 3}, Set2: {3, 4, 5} → Output: {1, 2, 4, 5}.

import java.util.*;
public class SymmetricDifference {
    public static ArrayList<Integer> symmetricDifference(HashSet<Integer> set1, HashSet<Integer> set2){
        ArrayList<Integer> list = new ArrayList<>();
        for(int num : set1){
            if(!set2.contains(num)) list.add(num);
        }
        for(int num : set2){
            if(!set1.contains(num)) list.add(num);
        }
        return list;
    }
    public static void main(String[] args) {
        HashSet<Integer> set1 = new HashSet<>(Arrays.asList(1,2,3));
        HashSet<Integer> set2 = new HashSet<>(Arrays.asList(3,4,5));
        System.out.println("Symmetric Difference: "+symmetricDifference(set1, set2));
    }
}
