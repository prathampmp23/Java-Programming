package Queue;

import java.util.*;

public class JCFQueue {
    public static void main(String[] args) {
        // Here Queue is not class it is interface
        // we cant made objects of interface
        Queue<Integer> q = new LinkedList<>(); // or ArrayDeque<>()
        q.add(1);
        q.add(2);
        q.add(3);

        while (!q.isEmpty()) {
            System.out.println(q.peek());
            q.remove();
        }
    }
}
