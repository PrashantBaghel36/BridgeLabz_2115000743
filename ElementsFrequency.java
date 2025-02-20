// Find Frequency of Elements
// Given a list of strings, count the frequency of each element and return the results in a Map<String, Integer>.
// Example:
// Input: ["apple", "banana", "apple", "orange"] → Output: {apple=2, banana=1, orange=1}.

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class ElementsFrequency {
    public static HashMap<String, Integer> countFrequency(ArrayList<String> list){
        HashMap<String, Integer> map = new HashMap<>();
        for(int i=0;i<list.size();i++){
            if(map.containsKey(list.get(i))){
                map.put(list.get(i), map.get(list.get(i))+1);
            }else{
                map.put(list.get(i), 1);

            }
        }
        return map;

    }
    public static void main(String[] args) {
        ArrayList<String> list = new ArrayList<>();
        list.add("Orange");
        list.add("Banana");
        list.add("Apple");
        list.add("Orange");
        list.add("Apple");
        HashMap<String, Integer> map = countFrequency(list);
        for(var entry : map.entrySet()){
            System.out.println(entry.getKey()+"="+entry.getValue());
        }
    }
}
