import java.util.*;
public class SpecificCharacter{
	public static void main(String args[]){
		Scanner sc = new Scanner(System.in);
        System.out.println("enter a string here---> ");
        String s = sc.nextLine();
        System.out.println("enter the character to remove---> ");
        char flag = sc.next().charAt(0);

        //remove character here---> 
        String newStr = "";
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) != flag) {
                newStr = newStr + s.charAt(i);
            }
        }
        System.out.println("Modified String: " + newStr);
		sc.close();
	}
}