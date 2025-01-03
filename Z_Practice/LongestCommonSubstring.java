package Z_Practice;
import java.util.Scanner;

public class LongestCommonSubstring {

    // Function to find the length of the longest common substring
    static int longestCommonSubstring(String str1, String str2) {
        int m = str1.length();
        int n = str2.length();
        int[][] dp = new int[m + 1][n + 1];
        int maxLength = 0;

        // Build the dp table
        for (int i = 1; i <= m; i++) {
            for (int j = 1; j <= n; j++) {
                if (str1.charAt(i - 1) == str2.charAt(j - 1)) {
                    dp[i][j] = dp[i - 1][j - 1] + 1;
                    maxLength = Math.max(maxLength, dp[i][j]);
                } else {
                    dp[i][j] = 0;
                }
            }
        }
        return maxLength;
    }

    // Function to print the longest common substring
    static String printLongestCommonSubstring(String str1, String str2) {
        int m = str1.length();
        int n = str2.length();
        int[][] dp = new int[m + 1][n + 1];
        int maxLength = 0;
        int endIndex = 0;

        // Build the dp table
        for (int i = 1; i <= m; i++) {
            for (int j = 1; j <= n; j++) {
                if (str1.charAt(i - 1) == str2.charAt(j - 1)) {
                    dp[i][j] = dp[i - 1][j - 1] + 1;
                    if (dp[i][j] > maxLength) {
                        maxLength = dp[i][j];
                        endIndex = i;
                    }
                } else {
                    dp[i][j] = 0;
                }
            }
        }
        return str1.substring(endIndex - maxLength, endIndex);
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter first string: ");
        String str1 = scanner.nextLine();
        System.out.print("Enter second string: ");
        String str2 = scanner.nextLine();

        int length = longestCommonSubstring(str1, str2);
        String substring = printLongestCommonSubstring(str1, str2);

        System.out.println("Length of Longest Common Substring: " + length);
        System.out.println("Longest Common Substring: " + substring);

        scanner.close();
    }
}
