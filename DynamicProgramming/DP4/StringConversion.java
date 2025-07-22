package DynamicProgramming.DP4;

public class StringConversion {
    // using tabulation O(n*m)
    public static int stringConversion(String str1, String str2) {
        int n = str1.length();
        int m = str2.length();
        int dp[][] = new int[n + 1][m + 1];
        // initialization 0th row and column
        for (int i = 0; i < n + 1; i++) {
            for (int j = 0; j < m + 1; j++) {
                if (i == 0) {
                    dp[i][j] = j;
                }
                if (j == 0) {
                    dp[i][j] = i;
                }
            }
        }

        for (int i = 1; i < n + 1; i++) {
            for (int j = 1; j < m + 1; j++) {
                if (str1.charAt(i - 1) == str2.charAt(j - 1)) { // same
                    dp[i][j] = dp[i - 1][j - 1];
                } else { // diff
                    int add = dp[i][j - 1] + 1;
                    int delete = dp[i - 1][j] + 1;
                    dp[i][j] = Math.min(add, delete);
                }
            }
        }

        return dp[n][m];
    }

    // using LCS
    public static int stringConversion2(String str1, String str2) {
        int n = str1.length();
        int m = str2.length();
        int lcsLen = lcsTabu(str1, str2);
        int del = n - lcsLen;
        int add = m - lcsLen;
        int total = del + add;
        return total;
    }

    public static int lcsTabu(String str1, String str2) {
        int n = str1.length();
        int m = str2.length();
        int dp[][] = new int[n + 1][m + 1];
        // initialization 0th row and column
        for (int i = 0; i < n + 1; i++) {
            for (int j = 0; j < m + 1; j++) {
                if (i == 0 || j == 0) {
                    dp[i][j] = 0;
                }
            }
        }

        for (int i = 1; i < n + 1; i++) {
            for (int j = 1; j < m + 1; j++) {
                if (str1.charAt(i - 1) == str2.charAt(j - 1)) { // same
                    dp[i][j] = dp[i - 1][j - 1] + 1;
                } else { // diff
                    int ans1 = dp[i - 1][j];
                    int ans2 = dp[i][j - 1];
                    dp[i][j] = Math.max(ans1, ans2);
                }
            }
        }

        return dp[n][m];
    }

    public static void main(String[] args) {
        String str1 = "pear";
        String str2 = "sea";
        // ans = 3 (delete P , delete r, insert s at p's position)

        System.out.println("String conversion = " + stringConversion(str1, str2));
        System.out.println("String conversion = " + stringConversion2(str1, str2));
    }
}
