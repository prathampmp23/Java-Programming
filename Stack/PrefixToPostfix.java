package Stack;

import java.util.Stack;

public class PrefixToPostfix {
    public static String prefixToPostfix(String s) {
        Stack<String> st = new Stack<>();

        for (int i = s.length()-1; i >= 0; i--) {
            char ch = s.charAt(i);
            // Operand (a-z)
            if (ch >= 'a' && ch <= 'z') {
                st.push(String.valueOf(ch));
            }
            // Operator
            else {
                String t1 = st.pop(); // right operand
                String t2 = st.pop(); // left operand
                String concat = t1 + t2 + ch;
                st.push(concat);
            }
        }
        return st.pop();
    }

    public static void main(String[] args) {
        String expression = "+ab";
        System.out.println(prefixToPostfix(expression));
    }
}
