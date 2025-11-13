package SlidingWindow;

public class CountNiceSubArr {
    public static int numberOfSubarrays(int[] nums, int k) {
        return fun(nums, k) - fun(nums, k - 1);
    }

    public static int fun(int[] nums, int k) {
        int l = 0, r = 0, cnt = 0;
        int odd = 0;

        while (r < nums.length) {
            if (nums[r] % 2 == 1)
                odd++;
            while (odd > k) {
                if (nums[l] % 2 == 1)
                    odd--;
                l++;
            }
            cnt = cnt + (r - l + 1);
            r++;
        }
        return cnt;
    }

    public static void main(String[] args) {
        int[] nums = { 1, 1, 2, 1, 1 };
        int k = 3;
        System.out.println(numberOfSubarrays(nums, k));
    }
}
