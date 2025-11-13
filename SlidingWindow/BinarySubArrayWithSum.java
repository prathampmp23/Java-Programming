package SlidingWindow;

public class BinarySubArrayWithSum {

    public static int numSubarraysWithSum(int[] nums, int goal) {
        return fun(nums, goal) - fun(nums, goal - 1);
    }

    public static int fun(int[] nums, int goal) {
        if (goal < 0)
            return 0;
        int l = 0, r = 0, sum = 0, cnt = 0;

        while (r < nums.length) {
            sum += nums[r];
            while (sum > goal) {
                sum = sum - nums[l];
                l++;
            }
            cnt = cnt + (r - l + 1);
            r++;
        }
        return cnt;
    }

    public static void main(String[] args) {
        int nums[] = { 1, 0, 1, 0, 1 };
        int goal = 2;
        System.out.println(numSubarraysWithSum(nums, goal));
    }
}
