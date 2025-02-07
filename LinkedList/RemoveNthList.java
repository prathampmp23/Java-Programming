package LinkedList;

public class RemoveNthList {
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

    public void addFirst(int data) {
        Node newNode = new Node(data);
        if (head == null) {
            head = tail = newNode;
            return;
        }
        newNode.next = head; // linking
        head = newNode;
    }

    public void addLast(int data) {
        Node newNode = new Node(data);
        if (head == null) {
            head = tail = newNode;
            return;
        }
        tail.next = newNode; // linking
        tail = newNode;
    }

    public void deleteNthfromEnd(int n) {
        // calculate size
        int Size = 0;
        Node temp = head;
        while (temp != null) {
            temp = temp.next;
            Size++;
        }
        if (Size == n) {
            head = head.next; // remove first
            return;
        }

        // size-n
        int i = 1;
        int idxtoFind = Size - n;
        Node prev = head;
        while (i < idxtoFind) {
            prev = prev.next;
            i++;
        }
        prev.next = prev.next.next;
        return;
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
        RemoveNthList l1 = new RemoveNthList();
        l1.addFirst(2);
        l1.addFirst(1);
        l1.addLast(3);
        l1.addLast(4);
        l1.addLast(5);
        l1.printList();
        l1.deleteNthfromEnd(3);
        l1.printList();
    }
}
