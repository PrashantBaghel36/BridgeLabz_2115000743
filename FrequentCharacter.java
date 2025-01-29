import java.util.*;
public class FrequentCharacter{
	public static void main(String args[]){
		Scanner sc = new Scanner(System.in);
        System.out.println("Enter a string here---> ");
        String s = sc.nextLine();
        //here i am using hashmap...
        HashMap<Character, Integer> hm = new HashMap<>();
        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);
            hm.put(ch, hm.getOrDefault(ch, 0) + 1);
        }

        //most frequent character her---> 
        char totalCharacter = ' ';
        int totalFreq = 0;
        for (Map.Entry<Character, Integer> entry : hm.entrySet()) {
            if (entry.getValue() > totalFreq) {
                totalFreq = entry.getValue();
                totalCharacter = entry.getKey();
            }
        }
        System.out.println("Most Frequent Character: '" + totalCharacter + "'");
		sc.close();
	}
}