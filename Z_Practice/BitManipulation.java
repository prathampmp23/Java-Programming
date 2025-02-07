package Z_Practice;

public class BitManipulation {

    public static void oddOrEven(int n) {
        int bitMask = 1;
        if ((n & bitMask) == 0) {
            System.out.println("Even number");
        } else {
            System.out.println("Odd number");
        }
    }

    public static int getIthBit(int n, int i) {
        int bitMask = 1 << i;
        if ((n & bitMask) == 0) {
            return 0;
        } else {
            return 1;
        }
    }

    public static int setIthBit(int n, int i) {
        int bitMask = 1 << i;
        return n | bitMask;
    }

    public static int clearIthBit(int n, int i) {
        int bitMask = ~(1 << i);
        return n & bitMask;
    }

    public static int updateIthBit(int n, int i, int newBit) {
        // if (newBit == 0) {
        // return clearIthBit(n, i);
        // } else {
        // return setIthBit(n, i);
        // }

        // or

        n = clearIthBit(n, i);
        int bitMask = newBit << i;
        return n | bitMask;
    }

    public static int clearlastIthBit(int n, int i) {
        int bitMask = -1 << i;
        return n & bitMask;
    }

    public static int clearBitInRange(int n, int i, int j) {
        int a = ((~0) << (j + 1));
        int b = (1 << i) - 1;
        int bitMask = a | b;
        return n & bitMask;
    }

    public static boolean isPowerOf2(int n) {
        return (n & (n - 1)) == 0;
    }

    public static int countBits(int n) {
        int count = 0;
        while (n > 0) {
            // Check LSB
            if ((n & 1) != 0) {
                count++;
            }
            n = n >> 1;
        }
        return count;
    }

    public static int fastExponentiation(int a, int n) {
        int ans = 1;
        while (n > 0) {
            // Check LSB
            if ((n & 1) != 0) {
                ans = ans * a;
            }
            a = a * a;
            n = n >> 1;
        }
        return ans;
    }

    /* Iterative Function to calculate (x^y)%p in O(log y) */
    public static int modularExponentiation(int x, int y, int p) {
        int ans = 1;
        while (y > 0) {
            // Check LSB
            if ((y & 1) != 0) {
                ans = ans * x;
            }
            x = x * x;
            y = y >> 1;
        }
        return ans % p;
    }

    public static void swapTwoNum(int a, int b) {
        System.out.println("before Swaping two num a = " + a + ", b = " + b);
        a = a ^ b;
        b = a ^ b;
        a = a ^ b;
        System.out.println("before Swaping two num a = " + a + ", b = " + b);
    }

    public static void toUppercaseBybit() {
        // Convert uppercase character
        for (char ch = 'A'; ch <= 'Z'; ch++) {
            System.out.print(ch);
        }
        // to lowercase
        System.out.println();
        for (char ch = 'A'; ch <= 'Z'; ch++) {
            System.out.print((char) (ch | ' '));
        }
    }

    public static void main(String[] args) {

        // Binary AND - &
        System.out.println(5 & 6); // 4

        // Binary OR - |
        System.out.println(5 | 6); // 7

        // Binary XOR - ^
        System.out.println(5 ^ 6); // 3

        // Binary one's Complement (NOT) - ~
        System.out.println(~5); // 2

        // Binary left shift - <<
        // formula => a << b = a * 2^b
        System.out.println(5 << 2); // 20

        // Binary Right shift - >>
        // formula => a >> b = a / 2^b
        System.out.println(5 >> 2); // 1

        // Odd or Even
        oddOrEven(1010);
        oddOrEven(3);

        // Get ith bit
        System.out.println("Get ith bit = " + getIthBit(4, 2));

        // Set ith bit
        System.out.println("Set ith bit = " + setIthBit(5, 1));

        // Clear ith bit
        System.out.println("Clear ith bit = " + clearIthBit(10, 1));

        // Update ith bit
        System.out.println("update ith bit = " + updateIthBit(10, 2, 1));

        // Clear Last ith bit
        System.out.println("Clear Last ith bit = " + clearlastIthBit(15, 2));

        // Clear bit in Range
        System.out.println("Clear bit in range = " + clearBitInRange(10, 2, 4));

        // Check is no is Power of 2 or not
        System.out.println("Number is power of 2 " + isPowerOf2(15));

        // Count no of set bits
        System.out.println("Number of bits in " + countBits(10));

        // Fast Exponentiation a^N
        System.out.println("Fast Exponentiation = " + fastExponentiation(5, 4));

        // Modular Exponentiation a^N
        System.out.println("modular Exponentiation = " + modularExponentiation(2,5,13));

        // Swap two no without using third variable or num
        swapTwoNum(3, 4);

        // add one to num
        int x = 7;
        System.out.println("No " + x + " + 1 = " + -~x);

        toUppercaseBybit();
    }
}