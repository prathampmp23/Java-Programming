package Queue;

public class ArrayQueue {

    static class Queue {
        static int arr[];
        static int size;
        static int rear;
        static int front;

        Queue(int n) {
            arr = new int[n];
            size = n;
            rear = -1;
        }

        // check Queue is Empty or not
        public static boolean isEmpty() {
            return rear == -1;
        }

        // Add O(1)
        public static void add(int data) {
            if (rear == size - 1) {
                System.out.println("Queue is Full!");
                return;
            }
            rear = rear + 1;
            arr[rear] = data;
        }

        // Remove O(n)
        public static int remove() {
            if (isEmpty()) {
                System.out.println("Queue is empty!");
                return -1;
            }
            int front = arr[0];
            // shift to previous index (front)
            for (int i = 0; i < rear; i++) {
                arr[i] = arr[i + 1];
            }
            rear = rear - 1;
            return front;
        }

        // Peek O(1)
        public static int peek() {
            if (isEmpty()) {
                System.out.println("Queue is empty!");
                return -1;
            }
            return arr[0];
        }
    }

    public static void main(String[] args) {
        // Queue q = new Queue(5);
        Queue.add(1);
        Queue.add(2);
        Queue.add(3);
        Queue.add(4);

        while (!Queue.isEmpty()) {
            System.out.println(Queue.peek());
            Queue.remove();
        }
    }
}
