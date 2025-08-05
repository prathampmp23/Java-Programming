package Arrays1D;

import java.util.HashMap;
import java.util.Map;

public class CountSubArrayWithSum {

    public static int subarraySum(int[] nums, int k) {
        int count = 0;
        int sum = 0;
        Map<Integer, Integer> map = new HashMap<>();
        map.put(0, 1);
        for (int num : nums) {
            sum += num;
            if (map.containsKey(sum - k)) {
                count += map.get(sum - k);
            }
            map.put(sum, map.getOrDefault(sum, 0) + 1);
        }
        return count;
    }

    public static void main(String[] args) {
        int arr[] = { 1, 2, 3, -3, 11, 1, 4, 2, -3 };
        System.out.println(subarraySum(arr, 3));
    }
}
