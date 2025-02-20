// Reverse a List
// Write a program to reverse the elements of a given List without using built-in reverse methods. 
// Implement it for both ArrayList and LinkedList.
// Example:
// Input: [1, 2, 3, 4, 5] → Output: [5, 4, 3, 2, 1].



import java.util.*;
public class ReveresList{
    public static ArrayList<Integer> reverseArrayList(ArrayList<Integer> arrayList){
        int left = 0;
        int right = arrayList.size()-1;
        while(left<right){
            int temp = arrayList.get(left);
            arrayList.set(left, arrayList.get(right));
            arrayList.set(right, temp);
            left++;
            right--;
        }
        return arrayList;
    }
    public static LinkedList<Integer> reverseLinkedList(LinkedList<Integer> linkedList){
        int left = 0;
        int right = linkedList.size()-1;
        while(left<right){
            int temp = linkedList.get(left); // 1,2,3,4,5 
            linkedList.set(left, linkedList.get(right));
            linkedList.set(right, temp);
            left++;
            right--;
        }
        return linkedList;
    }
    public static void main(String[] args) {
        LinkedList<Integer> linkedList = new LinkedList<>();
        ArrayList<Integer> arrayList = new ArrayList<>();
        arrayList.add(1);
        arrayList.add(2);
        arrayList.add(3);
        arrayList.add(4);
        arrayList.add(5);
        linkedList.add(1);
        linkedList.add(2);
        linkedList.add(3);
        linkedList.add(4);
        linkedList.add(5);
        System.out.println("Original ArrayList: "+arrayList);
        System.out.print("Reversed ArrayList: ");
        System.out.println(reverseArrayList(arrayList));
        System.out.println("Original LinkedList: "+linkedList);
        System.out.print("Reversed LinkedList: ");
        System.out.print(reverseLinkedList(linkedList));
    ;
    }
}