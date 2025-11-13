package SlidingWindow;

import java.util.HashSet;
import java.util.HashMap;

public class FruitsIntoBusket {

    // Brute O(N^2)
    public static int totalFruits(int[] fruits) {
        int maxLen = Integer.MIN_VALUE;

        for (int i = 0; i < fruits.length; i++) {
            HashSet<Integer> set = new HashSet<>();
            for (int j = i; j < fruits.length; j++) {
                set.add(fruits[j]);
                if (set.size() <= 2) {
                    maxLen = Math.max(maxLen, j - i + 1);
                } else {
                    break;
                }
            }
        }
        return maxLen;
    }

    // Optimal O(N)
    public static int totalFruits2(int[] fruits) {
        int l = 0, r = 0;
        int maxLen = Integer.MIN_VALUE;
        HashMap<Integer, Integer> map = new HashMap<>();

        while (r < fruits.length) {
            map.put(fruits[r], map.getOrDefault(fruits[r], 0) + 1);

            if (map.size() > 2) {
                int count = map.get(fruits[l]) - 1;
                if (count == 0) {
                    map.remove(fruits[l]);
                } else {
                    map.put(fruits[l], count);
                }
                l++;
            }
            if (map.size() <= 2) {
                maxLen = Math.max(maxLen, r - l + 1);
            }
            r++;
        }
        return maxLen;
    }

    public static void main(String[] args) {
        int fruits[] = { 1, 2, 3, 2, 2 };
        System.out.println(totalFruits(fruits));
        System.out.println(totalFruits2(fruits));
    }
}