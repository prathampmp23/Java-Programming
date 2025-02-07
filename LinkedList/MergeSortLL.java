package LinkedList;

public class MergeSortLL {
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

    // merge Sort
    public Node getMid(Node head) {
        Node slow = head;
        Node fast = head.next;
        while (fast != null && fast.next != null) {
            slow = slow.next; // move by +1
            fast = fast.next.next; // move by +2
        }
        return slow; // slow is midNode
    }

    public Node merge(Node head1, Node head2) {
        Node mergeList = new Node(-1);
        Node temp = mergeList;

        while (head1 != null && head2 != null) {
            if (head1.data <= head2.data) {
                temp.next = head1;
                head1 = head1.next;
                temp = temp.next;
            } else {
                temp.next = head2;
                head2 = head2.next;
                temp = temp.next;
            }
        }
        // for remaining
        while (head1 != null) {
            temp.next = head1;
            head1 = head1.next;
            temp = temp.next;
        }
        while (head2 != null) {
            temp.next = head2;
            head2 = head2.next;
            temp = temp.next;
        }

        return mergeList.next;
    }

    public Node mergeSort(Node head) {
        if (head == null || head.next == null) {
            return head;
        }
        // find mid
        Node mid = getMid(head);

        // apply mergeSort for left and right half
        Node rightHead = mid.next;
        mid.next = null;

        Node newLeft = mergeSort(head);
        Node newRight = mergeSort(rightHead);

        // Merge
        return merge(newLeft, newRight);
    }

    public static void main(String[] args) {
        // Merge sort - O(nlogn)
        // 5 -> 4 -> 3 -> 2 -> 1 -> null
        MergeSortLL ll = new MergeSortLL();
        ll.addFirst(1);
        ll.addFirst(2);
        ll.addFirst(3);
        ll.addFirst(4);
        ll.addFirst(5);
        ll.printLinkedList();
        MergeSortLL.head = ll.mergeSort(MergeSortLL.head);
        ll.printLinkedList();
    }

}
