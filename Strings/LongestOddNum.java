package Strings;

public class LongestOddNum {
    public static String largestOddNumber(String num) {
        // If the entire number is odd, return it directly
        if ((num.charAt(num.length() - 1) - '0') % 2 != 0)
            return num;

        // Start from the end and find the last odd digit
        for (int i = num.length() - 1; i >= 0; i--) {
            if ((num.charAt(i) - '0') % 2 != 0) {
                return num.substring(0, i + 1);
            }
        }

        // If no odd digit exists
        return "";
    }

    public static void main(String[] args) {
        String num = "123412";
        System.out.println(largestOddNumber(num));
    }
}