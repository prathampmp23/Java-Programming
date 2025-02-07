package Z_Practice;
// import java.util.LinkedList;

public class Linkedlist {
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

    // add at middle
    public void addAtMid(int idx, int data) {
        // special case
        // if idx == 0
        if (idx == 0) {
            addFirst(data);
            return;
        }
        Node newNode = new Node(data);
        size++;
        Node temp = head;
        int i = 0;

        while (i < idx - 1) {
            temp = temp.next;
            i++;
        }
        // i = idx - 1; temp -> prev
        newNode.next = temp.next;
        temp.next = newNode;
    }

    // remove from first
    public int removeFirst() {
        if (size == 0) {
            System.out.println("linked list is empty");
            return Integer.MIN_VALUE;
        } else if (size == 1) {
            int value = head.data;
            head = tail = null;
            size = 0;
            return value;
        }
        int value = head.data;
        head = head.next;
        size--;
        return value;
    }

    // remove from last
    public int removeLast() {
        if (size == 0) {
            System.out.println("linked list is empty");
            return Integer.MIN_VALUE;
        } else if (size == 1) {
            int value = head.data;
            head = tail = null;
            size = 0;
            return value;
        }
        // previous : i = size - 2
        Node prev = head;
        for (int i = 0; i < size - 2; i++) {
            prev = prev.next;
        }
        int value = prev.next.data; // tail.data;
        prev.next = null;
        tail = prev;
        size--;
        return value;
    }

    // Iterative Search
    public int itrativeSearch(int key) {
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

    // Recursive Search
    public int helperFun(Node head, int key) {
        // linked list is empty
        if (head == null) {
            return -1;
        }
        // key found
        if (head.data == key) {
            return 0;
        }
        // check is exist in next node
        int idx = helperFun(head.next, key);
        if (idx == -1) {
            return -1;
        }
        return idx + 1;
    }

    public int recursiveSearch(int key) {
        return helperFun(head, key);
    }

    // Reverse linkedList
    public void reverse() {
        Node prev = null;
        Node curr = tail = head;
        Node next;
        while (curr != null) {
            next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
        }
        head = prev;
    }

    public void delNthFromEnd(int n) {
        // calculate size
        int sz = 0;
        Node temp = head;
        while (temp != null) {
            temp = temp.next;
            sz++;
        }
        if (sz == n) {
            head = head.next; // Remove first
            return;
        }
        // sz-n
        int i = 1;
        int itoFind = sz - n;
        Node prev = head;
        while (i < itoFind) {
            prev = prev.next;
            i++;
        }
        prev.next = prev.next.next;
        return;

    }

    // Slow-fast approach
    public Node findMid(Node head) {
        Node slow = head;
        Node fast = head;
        while (fast != null && fast.next != null) {
            slow = slow.next; // move by +1
            fast = fast.next.next; // move by +2
        }
        return slow; // slow is midNode
    }

    public boolean isPalindrome() {
        // Base case
        if (head == null || head.next == null) {
            return true;
        }
        // 1] Find mid
        Node midNode = findMid(head);

        // 2] Reverse 2nd half
        Node prev = null;
        Node curr = midNode;
        Node next;
        while (curr != null) {
            next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
        }

        // 3] Check left and right half
        Node right = prev; // Right half head
        Node left = head; // Left half head

        while (right != null) {
            if (left.data != right.data) {
                return false;
            }
            left = left.next;
            right = right.next;
        }
        return true;
    }

    // floyed's cycle finding algorithm
    public static boolean isCycle() {
        Node slow = head;
        Node fast = head;
        while (fast != null && fast.next != null) {
            slow = slow.next; // move by +1
            fast = fast.next.next; // move by +2

            if (slow == fast) { // cycle exist
                return true;
            }
        }
        return false; // cycle dosen't exist
    }

    public static void removeCycle() {
        // Detect cycle
        Node slow = head;
        Node fast = head;
        boolean cycle = false;

        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
            if (slow == fast) {
                cycle = true;
                break;
            }
        }
        if (cycle == false) {
            return;
        }
        // Find meeting point
        slow = head;
        Node prev = null; // last node
        while (slow != fast) {
            prev = fast;
            slow = slow.next;
            fast = fast.next;
        }

        // Remove cycle lastNode.next -> null
        prev.next = null;
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

    public void zigZag() {
        // Find mid
        Node slow = head;
        Node fast = head.next;
        while (fast != null && fast.next != null) {
            slow = slow.next; // move by +1
            fast = fast.next.next; // move by +2
        }
        Node mid = slow;
        // Reverse 2nd half
        Node curr = mid.next;
        mid.next = null; // to seperate 2nd half
        Node prev = null;
        Node next;
        while (curr != null) {
            next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
        }

        // Alternate merge -> Zig-Zag merge
        Node left = head;
        Node right = prev;
        Node nextL, nextR;

        while (left != null && right != null) {
            // Zig Zag steps
            nextL = left.next;
            left.next = right;
            nextR = right.next;
            right.next = nextL;

            // updation steps
            left = nextL;
            right = nextR;
        }
    }

    public static void main(String[] args) {
        Linkedlist ll = new Linkedlist();
        // // Print linked list
        // ll.printLinkedList();

        // // insert at first
        // ll.addFirst(2);
        // ll.printLinkedList();
        // ll.addFirst(1);
        // ll.printLinkedList();

        // // insert at last
        // ll.addLast(4);
        // ll.printLinkedList();
        // ll.addLast(5);
        // ll.printLinkedList();

        // // insert at middle
        // ll.addAtMid(2, 3);
        // ll.printLinkedList();

        // // linkedlist size
        // System.out.println("Size = " + Linkedlist.size);

        // // Remove first
        // System.out.println(ll.removeFirst());
        // ll.printLinkedList();

        // // Remove last
        // System.out.println(ll.removeLast());
        // ll.printLinkedList();

        // // Iterative Search
        // System.out.println("Target found at index = " + ll.itrativeSearch(3));
        // // Recursive Search
        // System.out.println("Target found at index = " + ll.recursiveSearch(4));

        // // Reverse a linked list
        // ll.printLinkedList();
        // ll.reverse();
        // ll.printLinkedList();

        // // Find and Remove Nth node from end
        // ll.delNthFromEnd(3);
        // ll.printLinkedList();

        // ll.addLast(1);
        // ll.addLast(2);
        // ll.addLast(2);
        // ll.addLast(1);

        // System.out.println(ll.isPalindrome());

        // // linked list look like 1->2->3->2
        // head = new Node(1);
        // Node temp = new Node(2);
        // head.next = temp;
        // head.next.next = new Node(3);
        // head.next.next.next = temp;

        // System.out.println(isCycle());
        // removeCycle();
        // System.out.println(isCycle());

        // // create
        // LinkedList<Integer> LL = new LinkedList<>();

        // // add
        // LL.addLast(1);
        // LL.addLast(2);
        // LL.addFirst(0);

        // // To print LinkedList
        // System.out.println(LL);

        // // remove
        // LL.removeFirst();
        // LL.removeLast();
        // System.out.println(LL);

        // Merge sort - O(nlogn)
        // 5 -> 4 -> 3 -> 2 -> 1 -> null
        // ll.addFirst(1);
        // ll.addFirst(2);
        // ll.addFirst(3);
        // ll.addFirst(4);
        // ll.addFirst(5);
        // ll.printLinkedList();
        // Linkedlist.head = ll.mergeSort(Linkedlist.head);
        // ll.printLinkedList();
        
        // 1 -> 2 -> 3 -> 4 -> 5 -> null
        // ll.addFirst(6);
        ll.addFirst(5);
        ll.addFirst(4);
        ll.addFirst(3);
        ll.addFirst(2);
        ll.addFirst(1);
        ll.printLinkedList();
        ll.zigZag();
        ll.printLinkedList();
        
    }
}
