package SlidingWindow;

public class MaxConsecutiveOnes {
    // Brute
    public int longestOnes2(int[] nums, int k) {
        int cntOne = 0;
        for (int num : nums) {
            if (num == 1)
                cntOne++;
        }

        if (k == 0 && cntOne == 0)
            return 0;
        int maxLen = Integer.MIN_VALUE;
        for (int i = 0; i < nums.length; i++) {
            int zero = 0;
            for (int j = i; j < nums.length; j++) {
                if (nums[j] == 0)
                    zero++;
                if (zero <= k) {
                    int len = j - i + 1;
                    maxLen = Math.max(len, maxLen);
                } else {
                    break;
                }
            }
        }
        return maxLen;
    }

    // Optimal
    public static int longestOnes(int[] nums, int k) {
        int l = 0, r = 0, zero = 0;
        int maxLen = Integer.MIN_VALUE;

        while (r < nums.length) {
            if (nums[r] == 0)
                zero++;
            if (zero > k) {
                if (nums[l] == 0)
                    zero--;
                l++;
            }
            if (zero <= k) {
                int len = r - l + 1;
                maxLen = Math.max(len, maxLen);
            }
            r++;
        }
        return maxLen;
    }

    public static void main(String[] args) {
        int nums[] = { 1, 1, 1, 0, 0, 0, 1, 1, 1, 1, 0 };
        int k = 2;
        System.out.println(longestOnes(nums, k));
    }
}
