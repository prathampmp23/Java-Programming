package Heaps;

import java.util.PriorityQueue;

public class FindKthLargest {
    public static int findKthLargest(int[] nums, int k) {
        PriorityQueue<Integer> pq = new PriorityQueue<>((a, b) -> b - a);
        // (a, b) -> b - a == Comparator.reverseOrder()
        for (int num : nums) {
            pq.offer(num);
        }
        int kthLargest = 0;
        for (int i = 1; i <= k; i++) {
            kthLargest = pq.poll();
        }
        return kthLargest;
    }

    public static void main(String[] args) {
        System.out.println(findKthLargest(new int[] { 3, 2, 1, 5, 6, 4 }, 2)); // 5
        System.out.println(findKthLargest(new int[] { 3, 2, 3, 1, 2, 4, 5, 5, 6 }, 4)); // 4
    }
}
