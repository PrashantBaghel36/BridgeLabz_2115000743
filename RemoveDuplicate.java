import java.util.*;
public class RemoveDuplicate{
	public static void main(String args[]){
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter a string here---> ");
		String s = sc.nextLine();
		
		//we are removing the duplicate using hashmap here...
		HashMap<Character,Integer> hm = new HashMap<>();
		//taking the frequency....
		for(int i=0;i<s.length();i++){
			hm.put(s.charAt(i),hm.getOrDefault(s.charAt(i),0)+1);
		}
		String newStr = "";
		for(int i=0;i<s.length();i++){
			if(hm.get(s.charAt(i))>=1){
				newStr = newStr + s.charAt(i);
				hm.put(s.charAt(i),0);
			}
		}
		
		System.out.println("the string after removed-> "+newStr);
	}
}