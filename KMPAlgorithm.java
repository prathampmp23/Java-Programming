import java.util.Scanner;

public class KMPAlgorithm {

    // Function to build the LPS array
    public static void computeLPSArray(String pattern, int M, int[] lps) {
        int len = 0;  // length of the previous longest prefix suffix
        int i = 1;
        lps[0] = 0; // lps[0] is always 0

        // Calculate lps[i] for i = 1 to M-1
        while (i < M) {
            if (pattern.charAt(i) == pattern.charAt(len)) {
                len++;
                lps[i] = len;
                i++;
            } else {
                if (len != 0) {
                    len = lps[len - 1];
                } else {
                    lps[i] = 0;
                    i++;
                }
            }
        }
    }

    // KMP search function
    public static void KMPSearch(String pattern, String text) {
        int M = pattern.length();
        int N = text.length();

        // Create the lps array
        int[] lps = new int[M];
        computeLPSArray(pattern, M, lps);

        int i = 0; // index for text
        int j = 0; // index for pattern
        while (i < N) {
            if (pattern.charAt(j) == text.charAt(i)) {
                i++;
                j++;
            }
            if (j == M) {
                System.out.println("Found pattern at index " + (i - j));
                j = lps[j - 1];
            } else if (i < N && pattern.charAt(j) != text.charAt(i)) {
                if (j != 0) {
                    j = lps[j - 1];
                } else {
                    i++;
                }
            }
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter the text: ");
        String text = scanner.nextLine();

        System.out.print("Enter the pattern: ");
        String pattern = scanner.nextLine();

        KMPSearch(pattern, text);

        scanner.close();
    }
}
