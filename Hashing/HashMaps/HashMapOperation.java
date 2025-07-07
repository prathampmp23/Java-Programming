package Hashing.HashMaps;

import java.util.HashMap;
import java.util.Set;

public class HashMapOperation {
    public static void main(String[] args) {

        // create
        HashMap<String, Integer> map = new HashMap<>();

        // Insert - O(1)
        map.put("India", 150);
        map.put("China", 110);
        map.put("USA", 130);
        map.put("Russia", 140);
        map.put("Dubai", 100);

        System.out.println(map);

        // Get - O(1)
        int population = map.get("India");
        System.out.println("Population = " + population); // 150

        System.out.println(map.get("Canada")); // null

        // ContainsKey - O(1)
        System.out.println(map.containsKey("India")); // true
        System.out.println(map.containsKey("Canada")); // false

        // Remove - O(1)
        System.out.println(map.remove("China"));
        System.out.println(map);

        System.out.println(map.remove("Canada"));

        // Size
        System.out.println(map.size());

        // isEmpty
        System.out.println(map.isEmpty());

        // clear
        // map.clear();
        // System.out.println(map.isEmpty());

        // Iteration on HashMap

        Set<String> keys = map.keySet();
        System.out.println(keys);

        for (String k : keys) {
            System.out.println("Key = " + k + ", value = " + map.get(k));
        }

    }
}
