package Stack;

import java.util.*;

public class PushAtBottom {
    public static void puchAtBottom(Stack<Integer> s, int data) {
        if(s.isEmpty()) {
            // if stack is made empty or empty then push data 
            s.push(data);
            return;
        }
        int top = s.pop();
        puchAtBottom(s, data);
        s.push(top);
    }
    public static void main(String[] args) {
        // Stack using Java collection framework
        Stack<Integer> s = new Stack<>();
        s.push(1);
        s.push(2);
        s.push(3);

        puchAtBottom(s, 4);

        while (!s.isEmpty()) {
            // Peek
            System.out.println(s.peek());
            // Pop
            s.pop();
        }
    }
}
