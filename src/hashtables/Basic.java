package hashtables;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class Basic {
    public static void main(String[] args) {
        Map<Integer, String> employee = new HashMap<>();
        employee.put(1, "Sammsul Hoq");
        employee.put(2, "Jeff Stockett");
        employee.put(3, null);
        System.out.println(employee);
        System.out.println(employee.get(1));
        System.out.println(employee.containsKey(10));               // O(1)
        System.out.println(employee.containsValue("Dave Watson"));  // O(n)

        for (var item: employee.entrySet()) {
            System.out.println(item);
        }

        // Find first non-repeated characters in a string
        String input = "a green apple";
        Map<Character, Integer> frequencyTable = new HashMap<>();
        for(char c: input.toCharArray()){
            if (c != ' '){
                frequencyTable.put(c, frequencyTable.containsKey(c) ? frequencyTable.get(c) + 1 : 1);
            }
        }

        for (var item: frequencyTable.entrySet())
            if (item.getValue() == 1)
                System.out.println(item.getKey());

        // Another type of hash table is 'Set'
        Set<Integer> set = new HashSet<>();
        int[] numbers = {1, 2, 3, 4, 3, 3, 2, 1};
        for (var number: numbers)
            set.add(number);
        System.out.println(set);

        // Find first repeated characters
        Set<Character> characterset = new HashSet<>();
        for(char ch: input.toCharArray()) {
            if (!characterset.contains(ch))
                characterset.add(ch);
            else {
                System.out.println(ch);
                break;
            }
        }

        // Implementing MyHashTable
        MyHashTable myHashTable = new MyHashTable();
        myHashTable.put(1, "Apple");
        myHashTable.put(2, "Orange");
        myHashTable.put(3, "Banana");
        myHashTable.put(4, "Guava");
        myHashTable.put(5, "Muskmelon");
        myHashTable.put(6, "Watermelon");
        System.out.println(myHashTable.get(1));
        System.out.println(myHashTable.get(6));
        myHashTable.remove(5);
        System.out.println(myHashTable.get(5));
    }
}
