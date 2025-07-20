package DynamicProgramming.DP2;

public class ZeroOneKnapsacl {

    // using recursion - O(2^n)
    public static int knapsackRecursion(int val[], int wt[], int W, int n) {
        // base case
        if (W == 0 || n == 0) {
            return 0;
        }

        if (wt[n - 1] <= W) { // valid
            // include
            int ans1 = val[n - 1] + knapsackRecursion(val, wt, W - wt[n - 1], n - 1);

            // exclude
            int ans2 = knapsackRecursion(val, wt, W, n - 1);
            return Math.max(ans1, ans2);
        } else { // not valid
            // exclude
            return knapsackRecursion(val, wt, W, n - 1);
        }
    }

    // using memoization - O(n*W)
    public static int knapsackMemo(int val[], int wt[], int W, int n, int dp[][]) {
        // base case
        if (W == 0 || n == 0) {
            return 0;
        }

        if (dp[n][W] != -1) {
            return dp[n][W];
        }

        if (wt[n - 1] <= W) { // valid
            // include
            int ans1 = val[n - 1] + knapsackMemo(val, wt, W - wt[n - 1], n - 1, dp);
            // exclude
            int ans2 = knapsackMemo(val, wt, W, n - 1, dp);
            dp[n][W] = Math.max(ans1, ans2);
            return dp[n][W];
        } else { // not valid
            // exclude
            dp[n][W] = knapsackMemo(val, wt, W, n - 1, dp);
            return dp[n][W];
        }
    }

    // using tabulation - - O(n*W)
    public static int knapsackTabu(int val[], int wt[], int W) {
        int n = val.length;
        int dp[][] = new int[n + 1][W + 1];

        // for initializing 0th col
        for (int i = 0; i < dp.length; i++) {
            dp[i][0] = 0;
        }
        // for initializing 0th row
        for (int i = 0; i < dp[0].length; i++) {
            dp[0][i] = 0;
        }

        for (int i = 1; i < n + 1; i++) {
            for (int j = 1; j < W + 1; j++) {
                int value = val[i - 1]; // ith item value
                int weight = wt[i - 1]; // ith item weight

                // j => capacity
                if (weight <= j) { // valid
                    int includeProfit = value + dp[i - 1][j - weight];
                    int excludeProfit = dp[i - 1][j];
                    dp[i][j] = Math.max(includeProfit, excludeProfit);
                } else { // not valid
                    int excludeProfit = dp[i - 1][j];
                    dp[i][j] = excludeProfit;
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

        // recursion
        System.out.println("0-1 Knapsack using recursion = " + knapsackRecursion(val, wt, W, val.length));

        // memoization
        int dp[][] = new int[val.length + 1][W + 1];
        for (int i = 0; i < dp.length; i++) {
            for (int j = 0; j < dp[0].length; j++) {
                dp[i][j] = -1; // initialize
            }
        }
        System.out.println("0-1 Knapsack using memoiation = " + knapsackMemo(val, wt, W, val.length, dp));
        System.out.println("Memoization DP");
        printDP(dp);
        
        // tabulation
        System.out.println("0-1 Knapsack using tabulation = " + knapsackTabu(val, wt, W));
    }
}
