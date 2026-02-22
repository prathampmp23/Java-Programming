public class BinGapBtw1s {
    public static int binaryGap(int n) {
        String bin = Integer.toBinaryString(n);
        int lastIdx = -1;
        int maxGap = 0;

        for (int i = 0; i < bin.length(); i++) {
            if (bin.charAt(i) == '1') {
                if (lastIdx != -1) {
                    int gap = i - lastIdx;
                    maxGap = Math.max(maxGap, gap);
                }
                lastIdx = i;
            }
        }
        return maxGap;
    }

    public static void main(String[] args) {
        /*
         * Example 1:
         * Input: n = 22
         * Output: 2
         * 
         * Explanation: 22 in binary is "10110".
         * The first adjacent pair of 1's is "10110" with a distance of 2.
         * The second adjacent pair of 1's is "10110" with a distance of 1.
         * The answer is the largest of these two distances, which is 2.
         * Note that "10110" is not a valid pair since there is a 1 separating the two
         * 1's underlined.
         * 
         * Example 2:
         * Input: n = 8
         * Output: 0
         * 
         * Explanation: 8 in binary is "1000".
         * There are not any adjacent pairs of 1's in the binary representation of 8, so
         * we return 0.
         */
        System.out.println(binaryGap(22));
        System.out.println(binaryGap(8));
    }
}
