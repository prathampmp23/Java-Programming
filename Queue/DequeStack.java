package Queue;

import java.util.*;

public class DequeStack {
    static class Stack {
        Deque<Integer> d = new LinkedList<>();

        // Push
        public void push(int data) {
            d.addLast(data);
        }

        // Pop
        public int pop() {
            return d.removeLast();
        }

        // Peek
        public int peek() {
            return d.getLast();
        }
    }
    public static void main(String[] args) {
        Stack s = new Stack();
        s.push(1);
        s.push(2);
        s.push(3);
        s.pop();
        System.out.println(s.peek());
    }
}
