import java.util.Arrays;

public class ClimbingStairs2 {
    public static int climbStairs(int n, int[] costs) {
        int dp[] = new int[n + 1];
        Arrays.fill(dp, Integer.MAX_VALUE);
        dp[0] = 0;
        for (int j = 1; j <= n; j++) {
            for (int k = 1; k <= 3; k++) {
                int i = j - k;
                if (i >= 0) {
                    int jump = (j - i) * (j - i);
                    dp[j] = Math.min(dp[j], dp[i] + costs[j - 1] + jump);
                }
            }
        }
        return dp[n];
    }

    public static void main(String[] args) {
        /*
         * You are climbing a staircase with n + 1 steps, numbered from 0 to n.
         * 
         * You are also given a 1-indexed integer array costs of length n, where
         * costs[i] is the cost of step i.
         * From step i, you can jump only to step i + 1, i + 2, or i + 3. The cost of
         * jumping from step i to step j is defined as: costs[j] + (j - i)^2
         * 
         * You start from step 0 with cost = 0.
         * Return the minimum total cost to reach step n.
         * 
         * Input: n = 4, costs = [1,2,3,4]
         * Output: 13
         * Explanation:
         * 
         * One optimal path is 0 → 1 → 2 → 4
         * 
         * Jump  Cost Calculation              Cost
         * 0 → 1 costs[1] + (1 - 0)2 = 1 + 1 = 2
         * 1 → 2 costs[2] + (2 - 1)2 = 2 + 1 = 3
         * 2 → 4 costs[4] + (4 - 2)2 = 4 + 4 = 8
         * 
         * Thus, the minimum total cost is 2 + 3 + 8 = 13
         */
        int n = 4;
        int[] costs = new int[] { 1, 2, 3, 4 };
        System.out.println(climbStairs(n, costs));
    }
}
