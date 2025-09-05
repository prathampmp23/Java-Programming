package Strings;

public class LongestPalindrome {
    // optimal
    public static String longestPalindrome(String s) {
        if (s == null || s.length() < 2)
            return s;

        int start = 0, end = 0;

        // Single loop for all possible centers
        for (int i = 0; i < s.length(); i++) {
            // Odd-length palindrome (centered at i)
            int len1 = expandFromCenter(s, i, i);

            // Even-length palindrome (centered between i and i+1)
            int len2 = expandFromCenter(s, i, i + 1);

            // Take max length
            int len = Math.max(len1, len2);

            // Update longest palindrome indices
            if (len > end - start + 1) {
                start = i - (len - 1) / 2;
                end = i + len / 2;
            }
        }

        return s.substring(start, end + 1);
    }

    // Expands around given left and right pointers
    public static int expandFromCenter(String s, int left, int right) {
        while (left >= 0 && right < s.length() && s.charAt(left) == s.charAt(right)) {
            left--;
            right++;
        }
        return right - left - 1; // length of palindrome
    }

    // Brute
    public static String longestPalindrome2(String s) {
        String longest = "";

        // Outer loop: choose start index
        for (int i = 0; i < s.length(); i++) {
            // Inner loop: choose end index
            for (int j = i + 1; j <= s.length(); j++) {
                // substring(i, j) -> from i (inclusive) to j (exclusive)
                String sub = s.substring(i, j);

                // Check if palindrome
                if (isPalindrome(sub)) {
                    // Keep track of longest palindrome
                    if (sub.length() > longest.length()) {
                        longest = sub;
                    }
                }
            }
        }
        return longest;
    }

    public static boolean isPalindrome(String str) {
        for (int i = 0; i < str.length() / 2; i++) {
            int n = str.length();
            //not a palindrome
            if (str.charAt(i) != str.charAt(n - i - 1)) {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        String s = "abbabca";
        System.out.println(longestPalindrome(s));
        System.out.println(longestPalindrome2(s));
    }
}
