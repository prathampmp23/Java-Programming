package Hashing.HashSets;

import java.util.HashSet;
import java.util.Iterator;

public class HashSets {
    public static void main(String[] args) {

        // create
        HashSet<Integer> set = new HashSet<>();

        // Insert - O(1)
        set.add(1);
        set.add(2);
        set.add(3);
        set.add(4);
        set.add(5);
        set.add(6);
        set.add(1);
        set.add(2);

        System.out.println(set);

        // ContainsKey - O(1)
        System.out.println(set.contains(1)); // true
        System.out.println(set.contains(5)); // false

        // Remove - O(1)
        // set.remove(1);
        // System.out.println(set);

        // Size
        System.out.println(set.size());

        // isEmpty
        System.out.println(set.isEmpty());

        // clear
        // set.clear();
        System.out.println(set.isEmpty());

        // Iteration on Hashset

        // a. using Iterator
        @SuppressWarnings("rawtypes")
        Iterator it = set.iterator();
        while (it.hasNext()) {
            System.out.print(it.next() + " ");
        }

        System.out.println();

        // b. Using Enhance for loop
        for (Integer num : set) {
            System.out.print(num+" ");
        }

    }
}
