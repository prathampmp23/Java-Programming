package LinkedList;

public class IterativeSearch {

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

    // Add at the last
    public void addLast(int data) {
        // step1. create new node
        Node newNode = new Node(data);
        size++;
        // if linkedList is empty
        if (head == null) {
            head = tail = newNode;
            return;
        }
        // step2. tail next -> newNode
        tail.next = newNode; // link with next node

        // step3. tail = newNode
        tail = newNode;
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

    // Iterative Search
    public int iterativeSearch(int key) {
        Node temp = head;
        for (int i = 0; i < size; i++) {
            // key found
            if (temp.data == key) {
                return i;
            }
            temp = temp.next;
        }
        // key not found
        return -1;
    }

    public void printList() {
        if(head == null) {
            System.out.println("Linkedlist is empty");
            return;
        }
        Node temp = head;
        while(temp != null) {
            System.out.print(temp.data+" ");
            temp = temp.next;
        }
        System.out.println("->null");
    }

    public static void main(String args[]) {
        IterativeSearch l1 = new IterativeSearch();
        l1.addFirst(2);
        l1.addFirst(1);
        l1.addLast(3);
        l1.addLast(4);
        l1.printList();
        System.out.println(l1.iterativeSearch(3));
        System.out.println(l1.iterativeSearch(10));

    }
}