package Strings;

public class StringToIntAtoi {
    public static int myAtoi(String s) {
        s = s.trim(); // Remove leading whitespace
        int sign = 1, i = 0;
        long res = 0; // Using long to handle overflow cases

        if (s.length() == 0)
            return 0;

        // Check for sign
        if (s.charAt(0) == '-') {
            sign = -1;
            i++;
        } else if (s.charAt(0) == '+') {
            i++;
        }

        // Process numerical characters
        while (i < s.length()) {
            char ch = s.charAt(i);
            if (ch < '0' || ch > '9')
                break; // Stop at non-numeric character

            res = res * 10 + (ch - '0'); // Convert char to number
            if (sign * res > Integer.MAX_VALUE)
                return Integer.MAX_VALUE; // Handle overflow
            if (sign * res < Integer.MIN_VALUE)
                return Integer.MIN_VALUE;

            i++;
        }
        return (int) (sign * res);
    }

    public static void main(String[] args) {
        /*
         * Implement the myAtoi(string s) function, which converts a string to a 32-bit
         * signed integer.
         * 
         * The algorithm for myAtoi(string s) is as follows:
         * 
         * Whitespace: Ignore any leading whitespace (" ").
         * Signedness: Determine the sign by checking if the next character is '-' or
         * '+', assuming positivity if neither present.
         * Conversion: Read the integer by skipping leading zeros until a non-digit
         * character is encountered or the end of the string is reached. If no digits
         * were read, then the result is 0.
         * Rounding: If the integer is out of the 32-bit signed integer range [-231, 231
         * - 1], then round the integer to remain in the range. Specifically, integers
         * less than -231 should be rounded to -231, and integers greater than 231 - 1
         * should be rounded to 231 - 1.
         */
        String s = "1337c0d3";
        System.out.println(myAtoi(s));

    }
}
