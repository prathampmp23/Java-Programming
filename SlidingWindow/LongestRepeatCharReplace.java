package SlidingWindow;

public class LongestRepeatCharReplace {
    // Brute O(N^2)
    public static int characterReplacement(String s, int k) {
        int maxLen = Integer.MIN_VALUE;

        for (int i = 0; i < s.length(); i++) {
            int map[] = new int[26];
            int maxFreq = 0;
            for (int j = i; j < s.length(); j++) {
                map[s.charAt(j) - 'A']++;
                maxFreq = Math.max(maxFreq, map[s.charAt(j) - 'A']);

                int changes = (j - i + 1) - maxFreq;
                if (changes <= k) {
                    int len = j - i + 1;
                    maxLen = Math.max(len, maxLen);
                } else {
                    break;
                }
            }
        }
        return maxLen;
    }

    // Optimal O(N)
    public static int characterReplacement2(String s, int k) {
        int l = 0, r = 0;
        int maxFreq = 0;
        int maxLen = 0;
        int map[] = new int[26];

        while (r < s.length()) {
            char curr = s.charAt(r);
            map[curr - 'A']++;
            maxFreq = Math.max(maxFreq, map[curr - 'A']);

            while ((r - l + 1) - maxFreq > k) {
                map[s.charAt(l) - 'A']--;
                l++;
            }
            maxLen = Math.max(r - l + 1, maxLen);
            r++;
        }
        return maxLen;
    }

    public static void main(String[] args) {
        String s = "ABAB";
        int k = 2;

        System.out.println(characterReplacement(s, k));
        System.out.println(characterReplacement2(s, k));
    }
}
