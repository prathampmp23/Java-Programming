package Heaps;

import java.util.PriorityQueue;

public class NStraightHand {
    public static boolean isNStraightHand(int[] hand, int groupSize) {
        if (hand.length % groupSize != 0)
            return false;

        PriorityQueue<Integer> minHeap = new PriorityQueue<>();
        for (int card : hand)
            minHeap.add(card);

        while (!minHeap.isEmpty()) {
            int head = minHeap.poll();
            for (int i = 1; i < groupSize; i++)
                if (!minHeap.remove(head + i))
                    return false;
        }
        return true;
    }

    public static void main(String[] args) {
        int arr[] = { 1, 2, 3, 6, 2, 3, 4, 7, 8 };
        // hand can be rearranged as [1,2,3],[2,3,4],[6,7,8]
        System.out.println(isNStraightHand(arr, 3));
    }
}
