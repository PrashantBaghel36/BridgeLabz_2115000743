// Convert a Set to a Sorted List
// Convert a HashSet of integers into a sorted list in ascending order.
// Example:
// Input: {5, 3, 9, 1} → Output: [1, 3, 5, 9].

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;

public class SetToSortedList {
    public static void main(String[] args) {
        HashSet<Integer> set = new HashSet<>();
        set.add(5);
        set.add(3);
        set.add(9);
        set.add(1);
        ArrayList<Integer> list = new ArrayList<>(set);
        Collections.sort(list);
        System.out.println(list);
    }
}
