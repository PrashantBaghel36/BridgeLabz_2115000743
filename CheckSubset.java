// Find Subsets
// Check if one set is a subset of another.
// Example:
// Set1: {2, 3}, Set2: {1, 2, 3, 4} → Output: true.




import java.util.*;

public class CheckSubset {
    public static boolean checkSubset(HashSet<Integer> superSet, HashSet<Integer> subSet){
        for(int num : subSet){
            if(!superSet.contains(num)) return false;
        }
        return true;
    }
    public static void main(String[] args) {
        HashSet<Integer> superSet = new HashSet<>(Arrays.asList(1,2,3,4));
        HashSet<Integer> subSet = new HashSet<>(Arrays.asList(2,3));
        System.out.println(checkSubset(superSet, subSet));

    }
}
