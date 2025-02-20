// Union and Intersection of Two Sets
// Given two sets, compute their union and intersection.
// Example:
// Set1: {1, 2, 3}, Set2: {3, 4, 5} → Union: {1, 2, 3, 4, 5}, Intersection: {3}.

import java.util.*;
public class UnionAndIntersectionInSets {
    public static ArrayList<Integer> unionOfSets(HashSet<Integer> set1, HashSet<Integer> set2){
        ArrayList<Integer> list = new ArrayList<>();
        for(int num : set1){
            list.add(num);
        }
        for(int num : set2){
            if(!set1.contains(num)) list.add(num);
        }
        return list;
    }
    public static ArrayList<Integer> IntersectionOfSets(HashSet<Integer> set1, HashSet<Integer> set2){
        ArrayList<Integer> list = new ArrayList<>();
        for(int num : set1){
            if(set2.contains(num)) list.add(num);
        }
        return list;
    }
    public static void main(String[] args) {
        HashSet<Integer> set1 = new HashSet<>(Arrays.asList(1,2,3));
        HashSet<Integer> set2 = new HashSet<>(Arrays.asList(3,4,5));
        System.out.println("Union: "+unionOfSets(set1, set2));
        System.out.println("Intersection: "+IntersectionOfSets(set1, set2));

    }
}
