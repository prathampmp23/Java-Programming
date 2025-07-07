package Hashing.HashSets;

import java.util.HashSet;
import java.util.LinkedHashSet;

public class LinkedHashSets {
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

        // Insertion order is maintained
        LinkedHashSet<String> lhs = new LinkedHashSet<>();

        lhs.add("India");
        lhs.add("Japan");
        lhs.add("USA");
        lhs.add("China");
        lhs.add("Russia");
        lhs.add("Austrialia");

        System.out.println(lhs);
    }
}
