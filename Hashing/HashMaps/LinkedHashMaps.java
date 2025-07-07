package Hashing.HashMaps;

import java.util.LinkedHashMap;
import java.util.Set;

public class LinkedHashMaps {
    public static void main(String args[]) {

        // Stored in order of insertion
        LinkedHashMap<String, Integer> lmap = new LinkedHashMap<>();
        // Insert - O(1)
        lmap.put("India", 150);
        lmap.put("China", 110);
        lmap.put("USA", 130);
        lmap.put("Russia", 140);
        lmap.put("Dubai", 100);

        System.out.println(lmap);

        // Get - O(1)
        int population = lmap.get("India");
        System.out.println("Population = " + population); // 150

        System.out.println(lmap.get("Canada")); // null

        // ContainsKey - O(1)
        System.out.println(lmap.containsKey("India")); // true
        System.out.println(lmap.containsKey("Canada")); // false

        // Remove - O(1)
        System.out.println(lmap.remove("China"));
        System.out.println(lmap);

        System.out.println(lmap.remove("Canada"));

        // Size
        System.out.println(lmap.size());

        // isEmpty
        System.out.println(lmap.isEmpty());

        // clear
        // lmap.clear();
        // System.out.println(lmap.isEmpty());

        // Iteration on HashlMap

        Set<String> keys = lmap.keySet();
        System.out.println(keys);

        for (String k : keys) {
            System.out.println("Key = " + k + ", value = " + lmap.get(k));
        }
    }
}
