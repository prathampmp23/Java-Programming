package Hashing.HashSets;

import java.util.HashMap;

public class LargestSubArrayWithSumZero {
    public static void main(String[] args) {

        // T.c = O(n)
        int arr[] = { 15, -2, 2, -8, 1, 7 };

        HashMap<Integer, Integer> map = new HashMap<>();
        // (Sum, Index)

        int sum = 0;
        int length = 0;

        for (int j = 0; j < arr.length; j++) {
            sum += arr[j];
            if (map.containsKey(sum)) {
                length = Math.max(length, j - map.get(sum));
            } else {
                map.put(sum, j);
            }
        }

        System.out.println("Largest SubArray with sum 0 = " + length);

    }
}
