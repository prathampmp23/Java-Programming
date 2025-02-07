package Z_Practice;

public class DoublyLinkedList {

    public static class Node {
        int data;
        Node next;
        Node prev;

        // constructor
        public Node(int data) {
            this.data = data;
            this.next = null;
            this.prev = null;
        }
    }

    public static Node head;
    public static Node tail;
    public static int size;

    // Add at first
    public void addFirst(int data) {
        Node newNode = new Node(data);
        size++;
        if (head == null) {
            head = tail = newNode;
            return;
        }
        newNode.next = head;
        head.prev = newNode;
        head = newNode; // head points to newNode
    }

    public int removeFirst() {
        if (head == null) {
            System.out.println("Linked list is empty");
            return Integer.MIN_VALUE;
        }
        if (size == 1) {
            int value = head.data;
            head = tail = null;
            size--;
            return value;
        }
        int value = head.data;
        head = head.next;
        head.prev = null; // for single LL this cause error
        size--;
        return value;
    }

    public void print() {
        Node temp = head;
        while (temp != null) {
            System.out.print(temp.data + "<->");
            temp = temp.next;
        }
        System.out.println("null");
    }

    public void reverse() {
        Node prev = null;
        Node curr = head;
        Node next;
        while (curr != null) {
            next = curr.next;
            curr.next = prev;
            curr.prev = next;

            prev = curr;
            curr = next;
        }
        head = prev;
    }

    public static void main(String[] args) {
        DoublyLinkedList dll = new DoublyLinkedList();

        dll.addFirst(3);
        dll.addFirst(2);
        dll.addFirst(1);

        // dll.print();
        // System.out.println(size);
        
        // dll.removeFirst();
        // dll.print();
        // System.out.println(size);
        
        dll.print();
        dll.reverse();
        dll.print();
    }
}
