package Heaps;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class TopKFrequentEl {
    public int[] topKFrequent(int[] nums, int k) {
        int ans[] = new int[k];
        Map<Integer, Integer> map = new HashMap<>();
        for (int num : nums) {
            map.put(num, map.getOrDefault(num, 0) + 1);
        }
        List<Map.Entry<Integer, Integer>> list = new ArrayList<>(map.entrySet());
        list.sort((a, b) -> b.getValue() - a.getValue());

        for (int i = 0; i < k && i < list.size(); i++) {
            Map.Entry<Integer, Integer> e = list.get(i);
            ans[i] = e.getKey();
        }
        return ans;
    }

    public static void main(String[] args) {
        int[] nums = { 1, 1, 1, 2, 2, 3 };
        int k = 2;

        TopKFrequentEl TopK = new TopKFrequentEl();
        System.out.println(Arrays.toString(TopK.topKFrequent(nums, k)));

        int[] nums2 = { 1, 2, 1, 2, 1, 2, 3, 1, 3, 2 };
        int k2 = 3;
        System.out.println(Arrays.toString(TopK.topKFrequent(nums2, k2)));
    }
}
