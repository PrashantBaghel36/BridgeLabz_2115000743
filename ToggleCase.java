import java.util.*;
public class ToggleCase{
	public static void main(String args[]){
		Scanner sc = new Scanner(System.in);
        System.out.println("Enter a string here---> ");
        String s = sc.nextLine();

        //for toogling the first character the logic used as here----->
        String newStr = "";
        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);
            if (Character.isUpperCase(ch)) {
                newStr = newStr + Character.toLowerCase(ch);
            } else if (Character.isLowerCase(ch)) {
                newStr = newStr + Character.toUpperCase(ch);
            } else {
                newStr = newStr + ch;
            }
        }

        System.out.println("the toggled string is-> " + newStr);
		
		sc.close();
	}
}