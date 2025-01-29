import java.util.*;
public class ConsonantsAndVowels{
	public static void main(String args[]){
		Scanner sc = new Scanner(System.in);
		System.out.println("enter a string here--> ");
		String s = sc.nextLine();
		int v = 0; //initialize a variable for counting the vowels.....
		int c = 0; //initialize a variable for counting the consonants.....
		for(int i=0;i<s.length();i++){
			if(s.charAt(i)=='a' || s.charAt(i)=='e' || s.charAt(i)=='i' || s.charAt(i)=='o' || s.charAt(i)=='u'){
				v++;
			}
			else{
				c++;
			}
		}
		
		System.out.println("The total no. of consonants is "+c+" and vowels is "+v);
		
		sc.close();
	}
}