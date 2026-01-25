// package SlidingWindow;

import java.util.Arrays;

// Minimum Difference Between Highest and Lowest of K Scores

public class MinDiffOfKsize {
    public static int minimumDifference(int[] nums, int k) {
        if (nums.length == 1) return 0;
        Arrays.sort(nums);
        // min = num[j] 
        // max = nums[i]
        int j = 0, ans = Integer.MAX_VALUE;

        for (int i = 0; i < nums.length; i++) {
            if (i - j + 1 == k) { // to maintain window size
                ans = Math.min(ans, nums[i] - nums[j]);
                j++;
            }
        }
        return ans;
    }

    public static int minimumDifference2(int[] nums, int k) {
        Arrays.sort(nums);
        int min = Integer.MAX_VALUE;

        // Sliding window of size k --> [i + k - 1]
        for (int i = 0; i <= nums.length - k; i++) {
            int diff = nums[i + k - 1] - nums[i];
            min = Math.min(diff, min);
        }
        return min;
    }

    public static void main(String[] args) {
        int[] nums = {9,4,1,7};
        int k = 2;

        System.out.println(minimumDifference(nums, k));
        System.out.println(minimumDifference2(nums, k));
    }
}
