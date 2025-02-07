package Queue;

public class CircularQueue {

    static class Queue {
        static int arr[];
        static int size;
        static int rear;
        static int front;

        Queue(int n) {
            arr = new int[n];
            size = n;
            rear = -1;
            front = -1;
        }

        // check Queue is Empty or not
        public static boolean isEmpty() {
            return rear == -1 && front == -1;
        }

        // circular queue
        public static boolean isFull() {
            return (rear + 1) % size == front;
        }

        // Add O(1)
        public static void add(int data) {
            if (isFull()) {
                System.out.println("Queue is empty");
                return;
            }
            // add first element
            if (front == -1) {
                front = 0;
            }
            rear = (rear + 1) % size;
            arr[rear] = data;
        }

        // Remove O(1)
        public static int remove() {
            if (isEmpty()) {
                System.out.println("Queue is empty!");
                return -1;
            }
            int result = arr[front];

            // if last element is deleted
            if (rear == front) {
                rear = front = -1;
            } else {
                front = (front + 1) % size;
            }
            return result;
        }

        // Peek O(1)
        public static int peek() {
            if (isFull()) {
                System.out.println("Queue is full!");
                return -1;
            }
            return arr[front];
        }
    }

    public static void main(String[] args) {
        // Queue q = new Queue(5);
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
