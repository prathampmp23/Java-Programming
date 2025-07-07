package Hashing.HashMaps;

import java.util.TreeMap;
import java.util.Set;

public class TreeMaps {
    public static void main(String[] args) {
        // Keys are stored in Sorted order
        TreeMap<String, Integer> lmap = new TreeMap<>();
        // Insert - O(logn)
        lmap.put("India", 150);
        lmap.put("China", 110);
        lmap.put("USA", 130);
        lmap.put("Russia", 140);
        lmap.put("Dubai", 100);

        System.out.println(lmap);

        // Get - O(logn)
        int population = lmap.get("India");
        System.out.println("Population = " + population); // 150

        System.out.println(lmap.get("Canada")); // null

        // ContainsKey - O(1)
        System.out.println(lmap.containsKey("India")); // true
        System.out.println(lmap.containsKey("Canada")); // false

        // Remove - O(logn)
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
