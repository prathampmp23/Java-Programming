package DynamicProgramming.DP2;

public class UnboundedKnapsack {
    // using tabulation - - O(n*W)
    public static int unboundedKnapsack(int val[], int wt[], int W) {
        int n = val.length;
        int dp[][] = new int[n + 1][W + 1];

        // for initializing 0th col => j (size of knapsack)
        for (int i = 0; i < dp.length; i++) {
            dp[i][0] = 0;
        }
        // for initializing 0th row => i (no of item)
        for (int i = 0; i < dp[0].length; i++) {
            dp[0][i] = 0;
        }

        for (int i = 1; i < n + 1; i++) {
            for (int j = 1; j < W + 1; j++) {
                // i = item , j => capacity
                if (wt[i - 1] <= j) { // valid
                    // only change from 01-knapsack is not calculate for i-1th item => dp[i-1][j - wt[i - 1]]
                    // instead calculate for ith item repetition => dp[i][j - wt[i - 1]]
                    dp[i][j] = Math.max(val[i - 1] + dp[i][j - wt[i - 1]], dp[i - 1][j]);
                } else { // not valid
                    dp[i][j] = dp[i - 1][j];
                }
            }
        }
        System.out.println("Tabulation DP");
        printDP(dp);
        return dp[n][W];
    }

    public static void printDP(int dp[][]) {
        for (int i = 0; i < dp.length; i++) {
            for (int j = 0; j < dp[0].length; j++) {
                System.out.print(dp[i][j] + "  ");
            }
            System.out.println();
        }
    }

    public static void main(String[] args) {
        int val[] = { 15, 14, 10, 45, 30 }; // value
        int wt[] = { 2, 5, 1, 3, 4 }; // weight
        int W = 7; // capacity

        // tabulation
        System.out.println("0-1 Knapsack using tabulation = " + unboundedKnapsack(val, wt, W));
    }
}
