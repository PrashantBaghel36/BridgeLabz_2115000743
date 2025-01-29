import java.util.*;
public class CompareString{
	public static void main(String args[]){
		Scanner sc = new Scanner(System.in);
        System.out.println("enter the first string here---> ");
        String s1 = sc.nextLine();
        System.out.println("enter the second string here---> ");
        String s2 = sc.nextLine();

        int lowLength = Math.min(s1.length(), s2.length());
        boolean flag = true;

        for (int i = 0; i < lowLength; i++) {
            if (s1.charAt(i) != s2.charAt(i)) {
                flag = false;
                if (s1.charAt(i) < s2.charAt(i)) {
                    System.out.println(s1 + "comes before " + s2 + " in lexicographical order");
                } else {
                    System.out.println(s2 + "\" comes before " + s1 + " in lexicographical order");
                }
                return;
            }
        }

        //comparing the prefix of strings.....
        if (flag) {
            if (s1.length() < s2.length()) {
                System.out.println(s1 + "\" comes before \"" + s2 + "\" in lexicographical order.");
            } else if (s1.length() > s2.length()) {
                System.out.println(s2 + "comes before " + s1 + " in lexicographical order");
            } else {
                System.out.println("both same....");
            }
        }
		
		sc.close();
	}
}