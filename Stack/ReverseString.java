package Stack;

import java.util.*;

public class ReverseString {

    public static String reverseString(String str) {
        Stack<Character> s = new Stack<>();
        int idx = 0;
        while (idx < str.length()) {
            s.push(str.charAt(idx));
            idx++;
        }
        StringBuilder newStr = new StringBuilder("");
        while (!s.isEmpty()) {
            char curr = s.pop();
            newStr.append(curr);
        }

        return newStr.toString();
    }

    public static void main(String[] args) {
        String str = "abc";
        System.out.println(reverseString(str));
    }
}
