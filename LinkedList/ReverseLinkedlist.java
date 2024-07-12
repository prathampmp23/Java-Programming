package LinkedList;

public class ReverseLinkedlist {
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
        if(head == null){
            head = tail = newNode;
            return;
        }
        newNode.next = head; //linking
        head = newNode;
    }

    public void addLast(int data) {
        Node newNode = new Node(data);
        if(head == null){
            head = tail = newNode;
            return;
        }
        tail.next = newNode; //linking
        tail = newNode;
    }
    
    public void reverse() {
        //To reverse a linkedlist there are 
        //3 variables
        //and 4 step in loop
        Node prev = null;
        Node curr = tail = head;
        Node next;

        while(curr != null){
            next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
        }
        head = prev;
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
        ReverseLinkedlist l1 = new ReverseLinkedlist();
        l1.addFirst(2);
        l1.addFirst(1);
        l1.addLast(3);
        l1.addLast(4);
        l1.addLast(5);
        l1.printList();
        l1.reverse();
        l1.printList();
    }
}
