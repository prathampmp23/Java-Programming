package Queue;

import java.util.*;

public class DequeQueue {
    static class Queue {
        Deque<Integer> d = new LinkedList<>();

        // add
        public void add(int data) {
            d.addLast(data);
        }

        // remove
        public int remove() {
            return d.removeFirst();
        }

        // Peek
        public int peek() {
            return d.getFirst();
        }
    }

    public static void main(String[] args) {
        Queue s = new Queue();
        s.add(1);
        s.add(2);
        s.add(3);
        System.out.println(s.peek());
        s.remove();
        System.out.println(s.peek());
        s.remove();
        System.out.println(s.peek());
        s.remove();
    }
}
