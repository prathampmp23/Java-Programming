public class FindAvgMaxSum1 {
    public static double findMaxAverage(int[] nums, int k) {
        int sum = 0;
        for (int i = 0; i < k; i++) {
            sum += nums[i];
        }
        double maxSum = sum;
        for (int i = k; i < nums.length; i++) {
            sum = sum - nums[i - k];
            sum += nums[i];
            maxSum = Math.max(maxSum, sum);
        }
        return maxSum / k;
    }

    public static void main(String[] args) {
        int nums[] = { 1, 12, -5, -6, 50, 3 }, k = 4;
        System.out.println(findMaxAverage(nums, k));
    }
}
