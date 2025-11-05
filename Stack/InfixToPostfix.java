package Stack;

import java.util.Stack;

public class InfixToPostfix {

    public static String infixToPostfix(String s) {
        Stack<Character> st = new Stack<>();
        StringBuilder ans = new StringBuilder();

        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);

            // Operand (a-z)
            if (ch >= 'a' && ch <= 'z') {
                ans.append(ch);
            }
            // Opening bracket
            else if (ch == '(') {
                st.push(ch);
            }
            // Closing bracket
            else if (ch == ')') {
                while (!st.isEmpty() && st.peek() != '(') {
                    ans.append(st.pop());
                }
                if (!st.isEmpty() && st.peek() == '(') {
                    st.pop(); // remove '('
                }
            }
            // Operator
            else {
                while (!st.isEmpty() && priority(ch) <= priority(st.peek())) {
                    ans.append(st.pop());
                }
                st.push(ch);
            }
        }

        // Pop remaining operators
        while (!st.isEmpty()) {
            ans.append(st.pop());
        }

        return ans.toString();
    }

    public static int priority(char c) {
        if (c == '^')
            return 3;
        else if (c == '*' || c == '/')
            return 2;
        else if (c == '+' || c == '-')
            return 1;
        else
            return 0;
    }

    public static void main(String[] args) {
        String expression = "a+b*c";
        System.out.println(infixToPostfix(expression));
    }
}