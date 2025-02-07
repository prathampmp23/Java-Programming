package LinkedList;

public class DetectCycle {
    public class Linkedlist {
        public static class Node {
            int data;
            Node next;

            // constructor
            public Node(int data) {
                this.data = data;
                this.next = null;
            }
        }

        public static Node head;
        public static Node tail;
        public static int size;

        // Floyed's cycle finding algorithm
        public static boolean isCycle() {
            Node slow = head;
            Node fast = head;
            while (fast != null && fast.next != null) {
                slow = slow.next; // move by +1
                fast = fast.next.next; // move by +2

                if (slow == fast) { // cycle exist
                    return true;
                }
            }
            return false; // cycle dosen't exist
        }

        public static void removeCycle() {
            // Detect cycle
            Node slow = head;
            Node fast = head;
            boolean cycle = false;

            while (fast != null && fast.next != null) {
                slow = slow.next;
                fast = fast.next.next;
                if (slow == fast) {
                    cycle = true;
                    break;
                }
            }
            if (cycle == false) {
                return;
            }
            // Find meeting point
            slow = head;
            Node prev = null; // last node
            while (slow != fast) {
                prev = fast;
                slow = slow.next;
                fast = fast.next;
            }

            // Remove cycle lastNode.next -> null
            prev.next = null;
        }

        public static void main(String[] args) {
            // linked list look like 1->2->3->2
            head = new Node(1);
            Node temp = new Node(2);
            head.next = temp;
            head.next.next = new Node(3);
            head.next.next.next = temp;

            System.out.println(isCycle());
            removeCycle();
            System.out.println(isCycle());
        }
    }
}
