package Heaps;

import java.util.Arrays;
import java.util.List;
import java.util.PriorityQueue;

public class MinCostToConnectSticks {
    public static int connectSticks(List<Integer> sticks) {
        PriorityQueue<Integer> pq = new PriorityQueue<>();

        for (int s : sticks) {
            pq.offer(s);
        }

        int ans = 0;

        while (pq.size() > 1) {
            int a = pq.poll();
            int b = pq.poll();

            int cost = a + b;
            ans += cost;

            pq.offer(cost);
        }

        return ans;
    }

    public static void main(String[] args) {
        List<Integer> sticks = Arrays.asList(2, 4, 3);
        // Connect sticks 2 and 3 → cost = 2 + 3 = 5 (sticks = [5, 4]),
        // Connect sticks 4 and 5 → cost = 4 + 5 = 9 (sticks = [9]),
        // Total cost = 5 + 9 = 14
        System.out.println(connectSticks(sticks));

        List<Integer> sticks2 = Arrays.asList(1, 8, 3, 5);
        // Connect 1 and 3 → cost = 1 + 3 = 4 (sticks = [4, 8, 5]),
        // Connect 4 and 5 → cost = 4 + 5 = 9 (sticks = [9, 8]),
        // Connect 8 and 9 → cost = 8 + 9 = 17 (sticks = [17]),
        // Total cost = 4 + 9 + 17 = 30
        System.out.println(connectSticks(sticks2));
    }
}
