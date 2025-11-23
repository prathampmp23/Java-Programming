package Bit;

public class MinBitsReqReverse {
    public static int minimumFlips(int n) {
        StringBuilder temp = new StringBuilder();
        // Build binary representation (reversed order)
        while (n > 0) {
            temp.append((char) ('0' + (n & 1)));
            n >>= 1;
        }
        int rev = 0;
        int len = temp.length();
        // Compare each bit with its mirror position
        for (int i = 0; i < len; ++i) {
            if (temp.charAt(i) != temp.charAt(len - 1 - i)) {
                rev++;
            }
        }
        return rev;
    }

    public static void main(String[] args) {
        // 1010 => reverse 0101 total bits to flip = 4
        System.out.println(minimumFlips(10));
    }
}
