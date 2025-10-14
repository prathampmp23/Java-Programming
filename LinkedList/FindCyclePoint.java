package LinkedList;

public class FindCyclePoint {

    public static class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
            next = null;
        }
    }

    public static ListNode detectCycle(ListNode head) {
        ListNode slow = head;
        ListNode fast = head;

        while (fast != null && fast.next != null) {
            slow = slow.next; // move by +1
            fast = fast.next.next; // move by +2

            if (slow == fast) { // cycle exist
                ListNode entry = head;
                while (entry != slow) {
                    entry = entry.next;
                    slow = slow.next;
                }
                return entry;
            }
        }
        return null;
    }

    public static void main(String[] args) {
        // Example 1: head = [3,2,0,-4], pos = 1
        ListNode head1 = new ListNode(3);
        ListNode node2_1 = new ListNode(2);
        ListNode node0_1 = new ListNode(0);
        ListNode nodeNeg4_1 = new ListNode(-4);

        head1.next = node2_1;
        node2_1.next = node0_1;
        node0_1.next = nodeNeg4_1;
        nodeNeg4_1.next = node2_1; // Connects to node with value 2 (index 1)

        ListNode cycleStart1 = detectCycle(head1);
        System.out.print("Input: head = [3,2,0,-4], pos = 1\nOutput: ");
        if (cycleStart1 != null) {
            System.out.println("tail connects to node with value " + cycleStart1.val);
        } else {
            System.out.println("no cycle");
        }
        System.out.println("Explanation: There is a cycle in the linked list, where tail connects to the second node.\n");

        // Example 2: head = [1,2], pos = 0
        ListNode head2 = new ListNode(1);
        ListNode node2_2 = new ListNode(2);

        head2.next = node2_2;
        node2_2.next = head2; // Connects to node with value 1 (index 0)

        ListNode cycleStart2 = detectCycle(head2);
        System.out.print("Input: head = [1,2], pos = 0\nOutput: ");
        if (cycleStart2 != null) {
            System.out.println("tail connects to node with value " + cycleStart2.val);
        } else {
            System.out.println("no cycle");
        }
        System.out.println("Explanation: There is a cycle in the linked list, where tail connects to the first node.\n");

        // Example 3: head = [1], pos = -1
        ListNode head3 = new ListNode(1); // No next, so no cycle

        ListNode cycleStart3 = detectCycle(head3);
        System.out.print("Input: head = [1], pos = -1\nOutput: ");
        if (cycleStart3 != null) {
            System.out.println("tail connects to node with value " + cycleStart3.val);
        } else {
            System.out.println("no cycle");
        }
        System.out.println("Explanation: There is no cycle in the linked list.");
    }
}
