package LinkedList;

public class Palindromelinkedlist {
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
    
    //****slow-fast Approach****//
    public static Node findMid(Node head) {
        Node slow = head;
        Node fast = head;

        while(fast != null && fast.next != null) {
            slow = slow.next;   //+1 jumps
            fast = fast.next.next;  //+2 jumps
        }
        return slow;
    }
    public static boolean checkPalindrome() {
        if(head == null || head.next == null) {
            return true;
        }
        //step1 Find mid
        Node midNode = findMid(head);

        //step2 Find reverse of 2nd half
        Node prev = null;
        Node curr = midNode;
        Node next;
        while(curr != null){
            next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
        }

        Node right = prev;
        Node left = head;
        //step3 check left half & right half
        while(right != null){
            if(left.data != right.data){
                return false;
            }
            left = left.next;
            right = right.next;
        }
        return true;
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
        Palindromelinkedlist l1 = new Palindromelinkedlist();
        l1.addLast(1);
        l1.addLast(2);
        l1.addLast(2);
        // l1.addLast(1);

        l1.printList();
        System.out.println(checkPalindrome());
    }
}
