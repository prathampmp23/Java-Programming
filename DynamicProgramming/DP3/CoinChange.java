package DynamicProgramming.DP3;

public class CoinChange {
    
    // using tabulation - - O(n*sum)
    public static int coinChange(int coin[], int sum) {
        int n = coin.length;
        int dp[][] = new int[n + 1][sum + 1];

        // for initializing 0th col => j (size of knapsack)
        for (int i = 0; i < dp.length; i++) {
            dp[i][0] = 1;
        }

        // for initializing 0th row => i (no of item)
        // no need to do this as by default element init to 0 in any array in java not in c++ 
        for (int i = 1; i < dp[0].length; i++) {
            dp[0][i] = 0;
        }

        for (int i = 1; i < n + 1; i++) {
            for (int j = 1; j < sum + 1; j++) {
                // i = coin , j => sum/change
                // here wt = coin[i - 1]
                if (coin[i - 1] <= j) { // valid
                    // total ways
                    // include + exclude
                    dp[i][j] = dp[i][j - coin[i - 1]] + dp[i - 1][j];
                } else { // not valid
                    // exclude
                    dp[i][j] = dp[i - 1][j];
                }
            }
        }
        System.out.println("Tabulation DP");
        printDP(dp);
        return dp[n][sum];
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
        int coins[] = { 2, 5, 3, 6 };
        int sum = 10; // capacity

        // int coins[] = { 1,2,3};
        // int sum = 4; // capacity

        // tabulation
        System.out.println("Coin Change of sum " + sum + " total ways = " + coinChange(coins, sum));
    }
}
