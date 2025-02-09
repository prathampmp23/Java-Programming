package Queue;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class ReversalQueue {

    public static void reversalQueue(Queue<Integer> q) {
        Stack<Integer> s = new Stack<>();

        // Queue to Stack
        while (!q.isEmpty()) {
            s.push(q.remove());
        }
        // Stack to Queue
        while (!s.isEmpty()) {
            q.add(s.pop());
        }
    }

    public static void main(String[] args) {
        Queue<Integer> q = new LinkedList<>();
        q.add(1);
        q.add(2);
        q.add(3);
        q.add(4);
        q.add(5);
        reversalQueue(q);
        while (!q.isEmpty()) {
            System.out.print(q.peek() + " ");
            q.remove();
        }
    }
}