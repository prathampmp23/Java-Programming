package LinkedList;

public class ZigZagLL {

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

    // Add at the first
    public void addFirst(int data) {
        // step1. create new node
        Node newNode = new Node(data);
        size++;
        // if linkedList is empty
        if (head == null) {
            head = tail = newNode;
            return;
        }
        // step2. newNode next -> head
        newNode.next = head; // link with next node

        // step3. head = newNode
        head = newNode;
    }

    // Print linkedList
    public void printLinkedList() {
        Node temp = head;
        while (temp != null) {
            System.out.print(temp.data + " -> ");
            temp = temp.next;
        }
        System.out.println("null");
    }

    public void zigZag() {
        // Find mid
        Node slow = head;
        Node fast = head.next;
        while (fast != null && fast.next != null) {
            slow = slow.next; // move by +1
            fast = fast.next.next; // move by +2
        }
        Node mid = slow;
        // Reverse 2nd half
        Node curr = mid.next;
        mid.next = null; // to seperate 2nd half
        Node prev = null;
        Node next;
        while (curr != null) {
            next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
        }

        // Alternate merge -> Zig-Zag merge
        Node left = head;
        Node right = prev;
        Node nextL, nextR;

        while (left != null && right != null) {
            // Zig Zag steps
            nextL = left.next;
            left.next = right;
            nextR = right.next;
            right.next = nextL;

            // updation steps
            left = nextL;
            right = nextR;
        }
    }

    public static void main(String[] args) {
        // Merge sort - O(nlogn)
        // 5 -> 4 -> 3 -> 2 -> 1 -> null
        ZigZagLL ll = new ZigZagLL();
        // 1 -> 2 -> 3 -> 4 -> 5 -> null
        // ll.addFirst(6);
        ll.addFirst(5);
        ll.addFirst(4);
        ll.addFirst(3);
        ll.addFirst(2);
        ll.addFirst(1);
        ll.printLinkedList();
        ll.zigZag();
        ll.printLinkedList();
    }

}
