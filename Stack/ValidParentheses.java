package Stack;

import java.util.Stack;

public class ValidParentheses {

    public static boolean isValidParentheses(String str) {
        Stack<Character> s = new Stack<>();

        for (int i = 0; i < str.length(); i++) {
            char ch = str.charAt(i);
            // opening bracket
            if (ch == '(' || ch == '{' || ch == '[') {
                s.push(ch);
            }
            // closing brackets
            else {
                // if stack is empty
                if (s.isEmpty()) {
                    return false;
                }
                // check is pair exist
                if ((s.peek() == '(' && ch == ')')
                    || (s.peek() == '{' && ch == '}')
                    || (s.peek() == '[' && ch == ']')) {
                    s.pop(); // if pair exist
                } else {
                    return false;
                }
            }
        }
        if (s.isEmpty()) {
            return true;
        } else {
            return false;
        }
    }

    public static boolean isDuplicateParentheses(String str) {
        Stack<Character> s = new Stack<>();
        for (int i = 0; i < str.length(); i++) {
            char ch = str.charAt(i);
            // closing
            if (ch == ')') {
                int count = 0;
                while (s.pop() != '(') {
                    count++;
                }
                if (count < 1) {
                    return true; // duplicates
                }
            } else {
                // opening
                s.push(ch);
            }
        }
        return false;
    }

    public static void main(String[] args) {
        String str = "({}[])";
        System.out.println(isValidParentheses(str));

        String str1 = "(((a+b)+(c+d)))";
        System.out.println(isDuplicateParentheses(str1));
        String str2 = "((a+b)+(c+d))";
        System.out.println(isDuplicateParentheses(str2));
    }
}
