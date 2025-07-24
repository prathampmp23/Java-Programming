package DynamicProgramming.DP6;

public class MinimumPartitioning {

    // T.c = O(n*W)
    public static int minPartition(int nums[]) {
        int n = nums.length;
        int sum = 0;
        for (int i = 0; i < nums.length; i++) {
            sum += nums[i];
        }
        int W = sum / 2;
        int dp[][] = new int[n + 1][W + 1];

        for (int i = 1; i < n + 1; i++) {
            for (int j = 1; j < W + 1; j++) {
                if (nums[i - 1] <= j) { // valid
                    // include, exclude
                    dp[i][j] = Math.max(nums[i - 1] + dp[i - 1][j - nums[i - 1]], dp[i - 1][j]);
                } else { // not valid
                    // exclude
                    dp[i][j] = dp[i - 1][j];
                }
            }
        }
        int sum1 = dp[n][W];
        int sum2 = sum - sum1;
        int minDiff = Math.abs(sum2 - sum1);
        return minDiff;
    }

    public static boolean isPartition(int nums[]) {
        int n = nums.length;
        int sum = 0;
        for (int i = 0; i < nums.length; i++) {
            sum += nums[i];
        }

        // If sum is odd, we cannot partition into two equal subsets
        if (sum % 2 != 0) {
            return false;
        }

        int W = sum / 2;
        boolean[][] dp = new boolean[n + 1][W + 1];

        // Initialize first column: sum 0 is always possible
        for (int i = 0; i <= n; i++) {
            dp[i][0] = true;
        }

        // Fill the DP table
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= W; j++) {
                if (nums[i - 1] <= j) {
                    // Include or exclude current element
                    dp[i][j] = dp[i - 1][j - nums[i - 1]] || dp[i - 1][j];
                } else {
                    // Exclude
                    dp[i][j] = dp[i - 1][j];
                }
            }
        }

        return dp[n][W]; // True if subset with sum == sum/2 exists
    }

    public static void main(String[] args) {
        int nums[] = { 1, 6, 11, 5 };
        System.out.println("Min Sum = " + minPartition(nums));

        // check is partition is possible or not
        int nums2[] = { 1, 2, 3 }; // true
        System.out.println(isPartition(nums2)); // true
        System.out.println(isPartition(nums)); // false
    }
}
