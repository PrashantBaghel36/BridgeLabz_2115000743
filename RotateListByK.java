// Rotate Elements in a List
// Rotate the elements of a list by a given number of positions.
// Example:
// Input: [10, 20, 30, 40, 50], rotate by 2 → Output: [30, 40, 50, 10, 20].

import java.util.ArrayList;
import java.util.Scanner;

public class RotateListByK {
    public static ArrayList<Integer> reverseListByK(ArrayList<Integer> list, int left, int right){
        while(left<right){
            int temp = list.get(left);
            list.set(left, list.get(right));
            list.set(right, temp);
            left++;
            right--;
        }
        return list;
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        ArrayList<Integer> list = new ArrayList<>();
        list.add(10);
        list.add(20);
        list.add(30);
        list.add(40);
        list.add(50);
        System.out.println("Enter the value of K: ");
        int k = sc.nextInt();
        System.out.println("Original List: "+list);
        reverseListByK(list, 0, k-1);
        reverseListByK(list, k, list.size()-1);
        reverseListByK(list, 0, list.size()-1);
        System.out.print("Rotated list: ");
        System.out.println(list);
    }
}
