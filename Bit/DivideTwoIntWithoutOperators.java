package Bit;

public class DivideTwoIntWithoutOperators {
    public static int divide(int dividend, int divisor) {
        if (dividend == divisor) return 1;
        if (dividend == Integer.MIN_VALUE && divisor == -1) return Integer.MAX_VALUE;
        if (dividend == Integer.MIN_VALUE && divisor == 1) return Integer.MIN_VALUE;

        // Determine sign of result
        boolean negative = (dividend < 0) ^ (divisor < 0);

        // Convert to long to avoid overflow before taking abs()
        long n = Math.abs((long) dividend);
        long d = Math.abs((long) divisor);
        long quotient = 0;

        // Subtract multiples of divisor using bit shifts
        while (n >= d) {
            long temp = d;
            long multiple = 1;
            while (n >= (temp << 1)) {
                temp <<= 1;
                multiple <<= 1;
            }
            n -= temp;
            quotient += multiple;
        }

        // Apply sign
        quotient = negative ? -quotient : quotient;

        // Clamp to 32-bit integer range
        if (quotient > Integer.MAX_VALUE) return Integer.MAX_VALUE;
        if (quotient < Integer.MIN_VALUE) return Integer.MIN_VALUE;

        return (int) quotient;
    }

    public static void main(String[] args) {
        int dividend = 22, divisor = 3;
        System.out.println(divide(dividend, divisor));
        
        dividend = 7;
        divisor = -3;
        System.out.println(divide(dividend, divisor));
    }
}
