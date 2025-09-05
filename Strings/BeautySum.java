package Strings;

public class BeautySum {
    public static int beautySum(String s) {
        int n = s.length();
        int totalBeauty = 0;

        // Loop over all possible starting points
        for (int i = 0; i < n; i++) {
            int[] freq = new int[26]; // frequency array for 'a' to 'z'

            // Expand substring from i to j
            for (int j = i; j < n; j++) {
                // Update frequency of current character
                char ch = s.charAt(j);
                freq[ch - 'a']++;

                // Find maxFreq and minFreq among non-zero counts
                int maxFreq = Integer.MIN_VALUE;
                int minFreq = Integer.MAX_VALUE;

                for (int k = 0; k < 26; k++) {
                    if (freq[k] > 0) { // only consider characters that appeared
                        maxFreq = Math.max(maxFreq, freq[k]);
                        minFreq = Math.min(minFreq, freq[k]);
                    }
                }

                // Add beauty of this substring to the total
                totalBeauty += (maxFreq - minFreq);
            }
        }

        return totalBeauty;
    }

    public static void main(String[] args) {

        /*
         * The beauty of a string is the difference in frequencies between the most
         * frequent and least frequent characters.
         * 
         * For example, the beauty of "abaacc" is 3 - 1 = 2.
         * Given a string s, return the sum of beauty of all of its substrings.
         */
        String s = "aabcb";
        System.out.println(beautySum(s));
    }
}
