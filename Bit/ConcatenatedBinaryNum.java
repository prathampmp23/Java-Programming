public class ConcatenatedBinaryNum {
    public int concatenatedBinary(int n) {
        long result = 0;
        int mod = 1_000_000_007;
        int bits = 0;

        for (int i = 1; i <= n; i++) {
            // If i is power of 2, increase bit length
            if ((i & (i - 1)) == 0) {
                bits++;
            }

            result = ((result << bits) + i) % mod;
        }

        return (int) result;
    }

    /*
    * 
     * Example 1:
     * Input: n = 1
     * Output: 1
     * Explanation: "1" in binary corresponds to the decimal value 1.
     * 
     * Example 2:
     * Input: n = 3
     * Output: 27
     * Explanation: In binary, 1, 2, and 3 corresponds to "1", "10", and "11".
     * After concatenating them, we have "11011", which corresponds to the decimal
     * value 27.
     * 
     * Example 3:
     * Input: n = 12
     * Output: 505379714
     * Explanation: The concatenation results in
     * "1101110010111011110001001101010111100".
     * The decimal value of that is 118505380540.
     * After modulo 109 + 7, the result is 505379714.
     */
}
