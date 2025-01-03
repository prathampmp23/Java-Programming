package Z_Practice;
import java.util.Scanner;

public class MatrixChainMultiplication {

    // Function to find the minimum cost of multiplying matrices
    static int matrixChainOrder(int[] p, int n) {
        int[][] dp = new int[n][n];

        // dp[i][i] = 0, since we need zero multiplications to multiply one matrix
        for (int i = 1; i < n; i++)
            dp[i][i] = 0;

        // l is the chain length
        for (int l = 2; l < n; l++) {
            for (int i = 1; i < n - l + 1; i++) {
                int j = i + l - 1;
                dp[i][j] = Integer.MAX_VALUE;

                for (int k = i; k < j; k++) {
                    // Calculate q, the number of multiplications
                    int q = dp[i][k] + dp[k + 1][j] + p[i - 1] * p[k] * p[j];
                    if (q < dp[i][j])
                        dp[i][j] = q;
                }
            }
        }

        return dp[1][n - 1]; // The result is stored in dp[1][n-1]
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter the number of matrices: ");
        int n = scanner.nextInt();
        int[] p = new int[n + 1];

        System.out.println("Enter the dimensions: ");
        for (int i = 0; i <= n; i++) {
            p[i] = scanner.nextInt();
        }

        int minMultiplications = matrixChainOrder(p, n + 1);
        System.out.println("Minimum number of multiplications is " + minMultiplications);

        scanner.close();
    }
}
