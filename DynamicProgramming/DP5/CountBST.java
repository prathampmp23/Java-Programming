package DynamicProgramming.DP5;

public class CountBST {
    public static int countingTrees(int n) {
        int dp[] = new int[n + 1];

        // initialization
        dp[0] = 1;
        dp[1] = 1;

        for (int i = 2; i <= n; i++) {
            // Ci -> BST (i Nodes ) -> dp[i]
            for (int j = 0; j < i; j++) {
                // Ci = cj * ci-j-1
                int left = dp[j];
                int right = dp[i - j - 1];
                dp[i] += left * right;
            }
        }
        return dp[n];
    }

    public static void main(String[] args) {
        int n = 3;
        System.out.println("Counting Trees = " + countingTrees(n));

    }
}
