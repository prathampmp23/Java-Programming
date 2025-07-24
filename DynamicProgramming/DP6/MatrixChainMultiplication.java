package DynamicProgramming.DP6;

import java.util.Arrays;

public class MatrixChainMultiplication {

    // Using recursion
    public static int mcm(int arr[], int i, int j) {
        if (i == j) {
            return 0; // single matrix case
        }

        int minCost = Integer.MAX_VALUE; // +infinity

        for (int k = i; k <= j - 1; k++) {
            int cost1 = mcm(arr, i, k); // Ai ... Ak => cost = arr[i - 1] * arr[k]
            int cost2 = mcm(arr, k + 1, j); // Ak+1 ... Aj => cost = arr[k] * arr[j]
            int cost3 = arr[i - 1] * arr[k] * arr[j];
            int finalCost = cost1 + cost2 + cost3;
            minCost = Math.min(minCost, finalCost);
        }
        return minCost;
    }

    // Using momoization
    public static int mcmMemo(int arr[], int i, int j, int dp[][]) {
        if (i == j) {
            return 0; // single matrix case
        }
        // ans already exist
        if (dp[i][j] != -1) {
            return dp[i][j];
        }
        int minCost = Integer.MAX_VALUE; // +infinity

        for (int k = i; k <= j - 1; k++) {
            int cost1 = mcmMemo(arr, i, k, dp); // Ai ... Ak => cost = arr[i - 1] * arr[k]
            int cost2 = mcmMemo(arr, k + 1, j, dp); // Ak+1 ... Aj => cost = arr[k] * arr[j]
            int cost3 = arr[i - 1] * arr[k] * arr[j];
            int finalCost = cost1 + cost2 + cost3;
            minCost = Math.min(minCost, finalCost);
        }

        return dp[i][j] = minCost;
    }

    // using Tabulation
    public static int mcmTabu(int arr[]) {
        int n = arr.length;
        // create table
        int dp[][] = new int[n][n];

        // initialization
        for (int i = 0; i < dp.length; i++) {
            dp[i][i] = 0; // i == j
        }

        // filling bottom up
        for (int len = 2; len <= n - 1; len++) {
            for (int i = 1; i <= n - len; i++) { // row
                int j = i + len - 1; // col
                dp[i][j] = Integer.MAX_VALUE;
                for (int k = i; k <= j - 1; k++) {
                    int cost1 = dp[i][k];
                    int cost2 = dp[k + 1][j];
                    int cost3 = arr[i - 1] * arr[k] * arr[j];
                    dp[i][j] = Math.min(dp[i][j], cost1 + cost2 + cost3);
                }
            }
        }
        printDp(dp);
        return dp[1][n - 1];
    }

    public static void printDp(int dp[][]) {
        for (int i = 0; i < dp.length; i++) {
            for (int j = 0; j < dp[0].length; j++) {
                System.out.print(dp[i][j] + "  ");
            }
            System.out.println();
        }
    }

    public static void main(String[] args) {
        int arr[] = { 1, 2, 3, 4, 3 };
        int n = arr.length;
        System.out.println("Matrix Chain Multiplication minCost = " + mcm(arr, 1, n - 1));

        int dp[][] = new int[n][n];
        for (int i = 0; i < dp.length; i++) {
            Arrays.fill(dp[i], -1);
        }
        System.out.println("Matrix Chain Multiplication minCost = " + mcmMemo(arr, 1, n - 1, dp));

        System.out.println("Matrix Chain Multiplication minCost = " + mcmTabu(arr));
    }
}
