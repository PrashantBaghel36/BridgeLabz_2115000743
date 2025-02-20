// Remove Duplicates While Preserving Order
// Remove duplicate elements from a list while maintaining the original order of elements.
// Example:
// Input: [3, 1, 2, 2, 3, 4] → Output: [3, 1, 2, 4].

import java.util.ArrayList;
import java.util.HashSet;

public class RemoveDuplicatesPreservingOrder {
    public static ArrayList<Integer> removeDuplicates(ArrayList<Integer> list){
        ArrayList<Integer> ans = new ArrayList<>();
        HashSet<Integer> set = new HashSet<>();
        for(Integer value : list){
            if(!set.contains(value)){
                set.add(value);
                ans.add(value);
            }
        }
        return ans;
    }
    public static void main(String[] args) {
        ArrayList<Integer> list = new ArrayList<>();
        list.add(3);
        list.add(1);
        list.add(2);
        list.add(3);
        list.add(3);
        list.add(4);
        System.out.println("List: "+list);
        System.out.println("List after removing duplicates: "+removeDuplicates(list));
    }
}
