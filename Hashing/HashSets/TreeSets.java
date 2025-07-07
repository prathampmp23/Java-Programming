package Hashing.HashSets;

import java.util.HashSet;
import java.util.TreeSet;

public class TreeSets {
    public static void main(String[] args) {
        HashSet<String> hs = new HashSet<>();

        // Insert - O(1)
        hs.add("India");
        hs.add("Japan");
        hs.add("USA");
        hs.add("China");
        hs.add("Russia");
        hs.add("Austrialia");

        System.out.println(hs);

        // Sorted in ascending order
        TreeSet<String> lhs = new TreeSet<>();

        lhs.add("India");
        lhs.add("Japan");
        lhs.add("USA");
        lhs.add("China");
        lhs.add("Russia");
        lhs.add("Austrialia");

        System.out.println(lhs);
    }
}
