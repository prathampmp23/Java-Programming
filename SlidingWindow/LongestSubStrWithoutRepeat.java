package SlidingWindow;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class LongestSubStrWithoutRepeat {

    // Aprroach 1 sliding Window approach
    public static int lengthOfLongestSubstring(String s) {
        if (s.length() == 0)
            return 0;

        int hash[] = new int[256];
        Arrays.fill(hash, -1);

        int l = 0, r = 0;
        int maxLen = Integer.MIN_VALUE;

        while (r < s.length()) {
            if (hash[s.charAt(r)] != -1) {
                if (hash[s.charAt(r)] >= l) {
                    l = hash[s.charAt(r)] + 1;
                }
            }
            int len = r - l + 1;
            maxLen = Math.max(len, maxLen);
            hash[s.charAt(r)] = r;
            r++;
        }
        return maxLen;
    }

    // Aprroach 2 sliding Window approach
    public int lengthOfLongestSubstring2(String s) {
        Set<Character> set = new HashSet<>();
        int left = 0, maxLen = 0;

        for (int right = 0; right < s.length(); right++) {
            char c = s.charAt(right);

            // If duplicate found, shrink the window from left
            while (set.contains(c)) {
                set.remove(s.charAt(left));
                left++;
            }

            // Add current character to the window
            set.add(c);

            // Update max length
            maxLen = Math.max(maxLen, right - left + 1);
        }

        return maxLen;
    }

    public static void main(String[] args) {
        String s = "abcabcbb";
        System.out.println(lengthOfLongestSubstring(s));
    }
}