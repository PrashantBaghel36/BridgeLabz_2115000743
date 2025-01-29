import java.util.*;
public class SubString{
	public static void main(String args[]){
		Scanner sc = new Scanner(System.in);
        System.out.println("enter the string here---> ");
        String s = sc.nextLine();
        
        System.out.println("enter the sub string to here---> ");
        String s2 = sc.nextLine();
        sc.close();

        // counting occurrences of the sub string here....
        int c = 0;
        int idx = s.indexOf(s2);
        
        while (idx != -1) {
            c++;
            idx = s.indexOf(s2, idx + 1);
        }

        System.out.println("here sub string occurs " + c + " times ");
	}
}