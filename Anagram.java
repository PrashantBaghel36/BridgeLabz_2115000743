import java.util.*;
public class Anagram{
	public static void main(String args[]){
		Scanner sc = new Scanner(System.in);
        System.out.println("Enter the first string here---> ");
        String s1 = sc.nextLine().toLowerCase();//convert to lower case

        System.out.println("Enter the second string here---> ");
        String s2 = sc.nextLine().toLowerCase();
        // checking if the string is anagram or not.....
        if (helper(s1, s2)) {
            System.out.println("The strings are anagrams.");
        } else {
            System.out.println("The strings are not anagrams.");
        }
		
		sc.close();
	}
	public static boolean helper(String str1, String str2) {
        if (str1.length() != str2.length()) {
            return false;
        }

        char[] arr1 = str1.toCharArray();
        char[] arr2 = str2.toCharArray();
        Arrays.sort(arr1);
        Arrays.sort(arr2);
        return Arrays.equals(arr1, arr2);
    }
}