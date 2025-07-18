package DynamicProgramming.DP1;

import java.util.Arrays;

public class ClimbingStairs {

    // for 1 and 2 stair climb
    // Using recursion - O(2^n)
    public static int countWays(int n) {
        if (n == 0) {
            return 1; // one way exist
        }
        if (n < 0) {
            return 0; // no way exist
        }
        return countWays(n - 1) + countWays(n - 2);
    }

    // variation of climbing stairs
    // for 1, 2 and 3 stair climb
    public static int countWays3(int n) {
        if (n == 0) {
            return 1; // one way exist
        }
        if (n < 0) {
            return 0; // no way exist
        }
        return countWays(n - 1) + countWays(n - 2) + countWays(n - 3);
    }

    // Using Dynamic programming

    // using Memoization - O(n)
    public static int countOptimizeWays(int n, int ways[]) {
        if (n == 0) {
            return 1; // one way exist
        }
        if (n < 0) {
            return 0; // no way exist
        }

        // if already calculated
        if (ways[n] != -1) {
            return ways[n];
        }
        ways[n] = countOptimizeWays(n - 1, ways) + countOptimizeWays(n - 2, ways);
        return ways[n];
    }

    // Using Tabulation - O(n)
    public static int countTabulationWays(int n) {
        int dp[] = new int[n + 1];
        dp[0] = 1;
        for (int i = 1; i <= n; i++) {
            if (i == 1) {
                dp[i] = dp[i - 1] + 0;
            } else {
                dp[i] = dp[i - 1] + dp[i - 2];
            }
        }
        // ans
        return dp[n];
    }

    public static void main(String[] args) {
        int n = 5;

        int ways[] = new int[n + 1]; // by default initialize to 0 in all index
        Arrays.fill(ways, -1); // to put -1 at each index

        System.out.println("Total Ways = " + countWays(n)); // recursion
        System.out.println("Total Ways = " + countOptimizeWays(n, ways)); // memoization
        System.out.println("Total Ways = " + countTabulationWays(n)); // tabulation
    }
}
