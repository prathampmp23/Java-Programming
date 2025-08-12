package Strings;

public class MaxDepthofParentheses {

    public static int maxDepth(String s) {
        int max = 0;
        int curr = 0;
        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);
            if (ch == '(') {
                curr++;
                max = Math.max(max, curr);
            } else if (ch == ')') {
                curr--;
            }

        }
        return max;
    }

    public static void main(String[] args) {
        String s1 = "(1)+((2))+(((3)))";
        String s2 = "(1+(2*3)+((8)/4))+1";

        System.out.println(maxDepth(s1));
        System.out.println(maxDepth(s2));
    }
}