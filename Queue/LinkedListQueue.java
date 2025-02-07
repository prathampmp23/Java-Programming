package Queue;

public class LinkedListQueue {

    public static class Node {
        int data;
        Node next;

        public Node(int data) {
            this.data = data;
            this.next = null;
        }
    }

    static class Queue {
        static Node head;
        static Node tail;

        // check Queue is Empty or not
        public static boolean isEmpty() {
            return head == null && tail == null;
        }

        // Add O(1)
        public static void add(int data) {
            Node newNode = new Node(data);
            if (head == null) {
                head = tail = newNode;
                return;
            }
            tail.next = newNode;
            tail = newNode;
        }

        // Remove O(1)
        public static int remove() {
            if (isEmpty()) {
                System.out.println("Queue is empty!");
                return -1;
            }
            int front = head.data;
            // single element
            if (tail == head) {
                tail = head = null;
            } else {
                head = head.next;
            }
            return front;
        }

        // Peek O(1)
        public static int peek() {
            if (isEmpty()) {
                System.out.println("Queue is full!");
                return -1;
            }
            return head.data;
        }
    }

    public static void main(String[] args) {
        // Queue q = new Queue();
        Queue.add(1);
        Queue.add(2);
        Queue.add(3);
        System.out.println(Queue.remove());
        Queue.add(4);
        System.out.println(Queue.remove());
        Queue.add(5);

        while (!Queue.isEmpty()) {
            System.out.println(Queue.peek());
            Queue.remove();
        }
    }
}
