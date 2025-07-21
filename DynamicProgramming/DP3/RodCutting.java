package DynamicProgramming.DP3;

public class RodCutting {
    // using tabulation - - O(n*W)
    public static int rodCutting(int price[], int length[], int W) {
        int n = price.length;
        int dp[][] = new int[n + 1][W + 1];

        // Initialization or 0th row & col
        for (int i = 0; i < n + 1; i++) {
            for (int j = 0; j < W + 1; j++) {
                if (i == 0 || j == 0) {
                    dp[i][j] = 0;
                }
            }
        }

        for (int i = 1; i < n + 1; i++) {
            for (int j = 1; j < W + 1; j++) {
                // i = no of item , j => capacity(size of knapsack)
                if (length[i - 1] <= j) { // valid
                    // include , exclude
                    dp[i][j] = Math.max(price[i - 1] + dp[i][j - length[i - 1]], dp[i - 1][j]);
                } else { // not valid
                    // exclude
                    dp[i][j] = dp[i - 1][j];
                }
            }
        }
        System.out.println("Tabulation DP");
        printDP(dp);
        return dp[n][W]; // ans
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
        int price[] = { 1, 5, 8, 9, 10, 17, 17, 20 }; // val
        int length[] = { 1, 2, 3, 4, 5, 6, 7, 8 }; // pieces length => weight
        int rodLen = 8; // capacity ( W )

        // tabulation
        System.out.println("Maxprice of rod selling in market = " + rodCutting(price, length, rodLen));
    }
}
