package Stack;

import java.util.*;

public class JCFStack {
    public static void main(String[] args) {
        // Stack using Java collection framework
        Stack<Integer> s = new Stack<>();
        s.push(1);
        s.push(2);
        s.push(3);

        while (!s.isEmpty()) {
            // Peek
            System.out.println(s.peek());
            // Pop
            s.pop();
        }
    }
}
