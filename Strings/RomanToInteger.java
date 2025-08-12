package Strings;

public class RomanToInteger {
    public static int romanToInt(String s) {
        int ans = 0;
        int prevValue = 0;

        for (int i = s.length() - 1; i >= 0; i--) {
            int curr = 0;
            switch (s.charAt(i)) {
                case 'I':
                    curr = 1;
                    break;
                case 'V':
                    curr = 5;
                    break;
                case 'X':
                    curr = 10;
                    break;
                case 'L':
                    curr = 50;
                    break;
                case 'C':
                    curr = 100;
                    break;
                case 'D':
                    curr = 500;
                    break;
                case 'M':
                    curr = 1000;
                    break;
                default:
                    System.out.println("Invalid Roman numeral: " + s.charAt(i));
                    return -1;
            }

            if (curr < prevValue) {
                ans -= curr; // Subtraction rule
            } else {
                ans += curr;
            }
            prevValue = curr;
        }
        return ans;
    }

    public static void main(String[] args) {
        String s1 = "LVIII";
        String s2 = "MCMXCIV";

        System.out.println(romanToInt(s1));
        System.out.println(romanToInt(s2));
    }
}
