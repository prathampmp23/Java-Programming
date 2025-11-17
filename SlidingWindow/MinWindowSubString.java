package SlidingWindow;

public class MinWindowSubString {

    // Brute
    public static String minWindow(String s, String t) {
        int n = s.length();
        int m = t.length();
        if (m == 0)
            return "";
        int minLen = Integer.MAX_VALUE;
        int sIdx = -1;

        for (int i = 0; i < n; i++) {
            int hash[] = new int[256];
            int cnt = 0;
            // build frequency for t
            for (int j = 0; j < m; j++) {
                hash[t.charAt(j)]++;
            }
            // expand window starting at i
            for (int j = i; j < n; j++) {
                if (hash[s.charAt(j)] > 0)
                    cnt++;
                hash[s.charAt(j)]--;
                if (cnt == m) {
                    int len = j - i + 1;
                    if (len < minLen) {
                        minLen = len;
                        sIdx = i;
                    }
                    break; // found shortest window that starts at i
                }
            }
        }

        if (sIdx == -1)
            return ""; // no window found
        return s.substring(sIdx, sIdx + minLen); 
    }

    public static void main(String[] args) {
        String s = "ADOBECODEBANC", t = "ABC";
        System.out.println(minWindow(s, t));
    }
}
