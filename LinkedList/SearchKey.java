package LinkedList;

public class SearchKey {
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

    //to search element at index
    public int Search(int key) {
        Node temp = head;
        int i = 0;
        while(temp != null){
            if(temp.data == key){
                return i;
            }
            temp = temp.next;
            i++;
        }

        //key not found
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
        SearchKey l1 = new SearchKey();

        //To add element at first list
        l1.addFirst(2);
        l1.addFirst(1);

        //To add element at last list
        l1.addLast(3);
        l1.addLast(4);
        l1.printList();
        System.out.println(l1.Search(3));
        System.out.println(l1.Search(2));
        System.out.println(l1.Search(10));
        
    }
}