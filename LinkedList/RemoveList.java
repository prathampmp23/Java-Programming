package LinkedList;

public class RemoveList {
    public static class Node {
        int data;
        Node next;

        public Node(int data) {
            this.data = data;
            this.next = null;
        }
    }

    public static Node head;
    public static Node tail;
    public static int size;

    // it has time complexity of O(1) == constant
    public void addFirst(int data) {
        // step1 = Create new node
        Node newNode = new Node(data);
        size++;
        if (head == null) {
            head = tail = newNode;
            return;
        }
        // step2 -> newNode = head
        // to point newNodenext node to head
        newNode.next = head; // linking

        // step3 -> head = newNode
        head = newNode;
    }

    // it has time complexity of O(1) == constant
    public void addLast(int data) {
        // step1 = Create new node
        Node newNode = new Node(data);
        size++;
        if (head == null) {
            head = tail = newNode;
            return;
        }
        // step2 -> tail.next = newNode
        // to point tailnext node to newnode
        tail.next = newNode; // linking

        // step3 -> tail = newNode
        tail = newNode;
    }

    public int removeFirst() {
        // special casees
        if (size == 0) {
            System.out.println("Linkedlist is empty");
            return Integer.MIN_VALUE; // +Infinity
        } else if (size == 1) {
            int val = head.data;
            head = tail = null;
            size = 0;
            return val;
        }
        int value = head.data; // to give first list value
        head = head.next; // to point to next list
        size--;
        return value;
    }

    public int removeLast() {
        // special casees
        if (size == 0) {
            System.out.println("Linkedlist is empty");
            return Integer.MIN_VALUE; // +Infinity
        } else if (size == 1) {
            int val = head.data;
            head = tail = null;
            size = 0;
            return val;
        }

        // Previous : i = size-2
        Node Previous = head;
        for (int i = 0; i < size - 2; i++) {
            Previous = Previous.next;
        }

        int value = Previous.next.data; // Means tail.data
        Previous.next = null;
        tail = Previous;
        size--;
        return value;
    }

    public void printList() {
        if (head == null) {
            System.out.println("Linkedlist is empty");
            return;
        }
        Node temp = head;
        while (temp != null) {
            System.out.print(temp.data + " ");
            temp = temp.next;
        }
        System.out.println("->null");
    }

    public static void main(String args[]) {
        RemoveList l1 = new RemoveList();
        l1.printList();
        l1.addFirst(2);
        l1.printList();
        l1.addFirst(1);
        l1.printList();
        l1.addLast(3);
        l1.printList();
        l1.addLast(4);
        l1.printList();
        // Remove first
        l1.removeFirst();
        l1.printList();
        // Remove last
        l1.removeLast();
        l1.printList();
    }
}
