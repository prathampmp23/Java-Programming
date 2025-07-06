package Heaps;

import java.util.PriorityQueue;

public class SlidingWindow {

    static class Pair implements Comparable<Pair> {
        int val;
        int idx;

        public Pair(int val, int idx) {
            this.val = val;
            this.idx = idx;
        }

        @Override
        public int compareTo(Pair p2) {
            // ascending (minimum)
            // return this.val - p2.val;
            // descending (maximum)
            return p2.val - this.val;
        }
    }

    public static void main(String[] args) {

        // T.C = O(nlogk)
        int arr[] = { 1, 3, -1, -3, 5, 3, 6, 7 };
        int k = 3; // window size
        int result[] = new int[arr.length - k + 1]; // Size = n-k+1

        PriorityQueue<Pair> pq = new PriorityQueue<>();

        // first window
        for (int i = 0; i < k; i++) {
            pq.add(new Pair(arr[i], i));
        }

        result[0] = pq.peek().val;

        for (int i = k; i < arr.length; i++) {
            // if PQ top has element which is not part of window
            while (pq.size() > 0 && pq.peek().idx <= (i - k)) {
                // then remove it
                pq.remove();
            }

            // add current
            pq.add(new Pair(arr[i], i));
            result[i - k + 1] = pq.peek().val;
        }

        // print result
        for (int i = 0; i < result.length; i++) {
            System.out.print(result[i] + " ");
        }

    }
}
