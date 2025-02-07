package Stack;

import java.util.*;

public class ReverseStack {
    public static void puchAtBottom(Stack<Integer> s, int data) {
        if (s.isEmpty()) {
            // if stack is made empty or empty then push data
            s.push(data);
            return;
        }
        int top = s.pop();
        puchAtBottom(s, data);
        s.push(top);
    }

    public static void reverseStack(Stack<Integer>s) {
        if (s.isEmpty()) {
            return;
        }
        // pop top
        int top = s.pop();
        // next call
        reverseStack(s);
        // push at bottom
        puchAtBottom(s, top);
    }

    public static void printStack(Stack<Integer>s) {
        while (!s.isEmpty()) {
            // Peek
            System.out.println(s.peek());
            // Pop
            s.pop();
        }
    }

    public static void main(String[] args) {
        Stack<Integer> s = new Stack<>();
        // 3, 2, 1
        s.push(1);
        s.push(2);
        s.push(3);

        reverseStack(s);
        // 1, 2, 3
        printStack(s);
    }
}
