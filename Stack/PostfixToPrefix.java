package Stack;

import java.util.Stack;

public class PostfixToPrefix {
    public static String postfixToPrefix(String s) {
        Stack<String> st = new Stack<>();

        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);

            // Operand (a-z)
            if (ch >= 'a' && ch <= 'z') {
                st.push(String.valueOf(ch));
            }
            // Operator
            else {
                String t1 = st.pop(); // right operand
                String t2 = st.pop(); // left operand
                String concat = ch + t2 + t1;
                st.push(concat);
            }
        }
        return st.pop();
    }

    public static void main(String[] args) {
        String expression = "ab+";
        System.out.println(postfixToPrefix(expression));
    }
}
