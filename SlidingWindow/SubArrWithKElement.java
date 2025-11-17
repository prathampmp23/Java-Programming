package SlidingWindow;

import java.util.HashMap;

public class SubArrWithKElement {
    public static int subarraysWithKDistinct(int[] nums, int k) {
        return fun(nums, k) - fun(nums, k - 1);
    }

    public static int fun(int[] nums, int k) {
        if (k < 0)
            return 0;
        int l = 0, r = 0;
        int cnt = 0;
        HashMap<Integer, Integer> map = new HashMap<>();

        while (r < nums.length) {
            map.put(nums[r], map.getOrDefault(nums[r], 0) + 1);

            while (map.size() > k) {
                int count = map.get(nums[l]) - 1;
                if (count == 0) {
                    map.remove(nums[l]);
                } else {
                    map.put(nums[l], count);
                }
                l++;
            }
            if (map.size() <= k) {
                cnt = cnt + (r - l + 1);
            }
            r++;
        }
        return cnt;
    }

    public static void main(String[] args) {
        int[] nums = { 1, 2, 1, 2, 3 };
        int k = 2;

        System.out.println(subarraysWithKDistinct(nums, k));
    }
}
