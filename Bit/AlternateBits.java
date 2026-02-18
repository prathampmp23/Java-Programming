// package Bit;

public class AlternateBits {

    public static boolean hasAlternatingBits(int n) {
        String bin = Integer.toBinaryString(n); // convert number to BinaryForm
        for (int i = 1; i < bin.length(); i++) {
            if (bin.charAt(i - 1) == bin.charAt(i))
                return false;
        }
        return true;
    }

    public static void main(String[] args) {
        /*
         * Example 1:
         * Input: n = 5
         * Output: true
         * Explanation: The binary representation of 5 is: 101
         * 
         * Example 2:
         * Input: n = 7
         * Output: false
         * Explanation: The binary representation of 7 is: 111.
         */
        System.out.println(hasAlternatingBits(5));
        System.out.println(hasAlternatingBits(7));
    }
}