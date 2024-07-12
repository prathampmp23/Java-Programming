package LinkedList;

public class AddList {
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

//it has time complexity of O(1) == constant
    public void addFirst(int data) {
        //step1 = Create new node
        Node newNode = new Node(data);
        if(head == null){
            head = tail = newNode;
            return;
        }
        //step2 -> newNode = head
        //to point newNodenext node to head
        newNode.next = head; //linking

        //step3 -> head = newNode
        head = newNode;
    }

//it has time complexity of O(1) == constant
    public void addLast(int data) {
        //step1 = Create new node
        Node newNode = new Node(data);
        if(head == null){
            head = tail = newNode;
            return;
        }
        //step2 -> tail.next = newNode
        //to point tailnext node to newnode
        tail.next = newNode; //linking

        //step3 -> tail = newNode
        tail = newNode;
    }

    public void addMiddle(int idx, int data) {
        if(idx == 0){
            addFirst(data);
            return;
        }
        Node newnode = new Node(data);
        Node temp = head;
        int i=0;

        while(i < idx-1) {
            temp = temp.next;
            i++;
        }

        //i = idx-1;
        //temp -> previous
        newnode.next = temp.next;
        temp.next = newnode;
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
        AddList l1 = new AddList();
        l1.printList();

        //To add element at first list
        l1.addFirst(2);
        l1.printList();
        l1.addFirst(1);
        l1.printList();

        //To add element at last list
        l1.addLast(3);
        l1.printList();
        l1.addLast(4);
        l1.printList();

        //add element at any given index
        l1.addMiddle(2,9);
        l1.printList();
    }
}