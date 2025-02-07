package LinkedList;

public class RecursiveSearch {

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
    public int helperFun(Node head , int key) { //O(n)
        if(head == null){
            return -1;
        }
        if(head.data == key){
            return 0;
        }
        //recursion step
        int index = helperFun(head.next, key);
        if(index == -1){
            return -1;
        }

        return index+1;
    }
    // recursive search
    public int recursiveSearch(int key) {
        return helperFun(head, key);
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
        RecursiveSearch l1 = new RecursiveSearch();
        l1.addFirst(2);
        l1.addFirst(1);
        l1.addLast(3);
        l1.addLast(4);
        l1.printList();
        System.out.println(l1.recursiveSearch(3));
        System.out.println(l1.recursiveSearch(10));

    }
}