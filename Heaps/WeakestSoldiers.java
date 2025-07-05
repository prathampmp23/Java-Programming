package Heaps;

import java.util.PriorityQueue;

public class WeakestSoldiers {

    static class Soldier implements Comparable<Soldier> {
        int soldier;
        int idx;

        public Soldier(int soldier, int idx) {
            this.soldier = soldier;
            this.idx = idx;
        }

        @Override
        public int compareTo(Soldier s2) {
            if (this.soldier == s2.soldier) {
                return this.idx - s2.idx;
            } else {
                return this.soldier - s2.soldier;
            }
        }
    }

    public static void main(String[] args) {
        int army[][] = { { 1, 0, 0, 0 }, { 1, 1, 1, 1 }, { 1, 0, 0, 0 }, { 1, 0, 0, 0 } };
        int k = 2;

        PriorityQueue<Soldier> pq = new PriorityQueue<>();
        // PriorityQueue<Soldier> pq = new PriorityQueue<>((s1, s2) -> s1.soldier == s2.soldier ? s1.idx - s2.idx : s1.soldier - s2.soldier);

        for (int i = 0; i < army.length; i++) {
            int count = 0;
            for (int j = 0; j < army[0].length; j++) {
                count += army[i][j] == 1 ? 1 : 0;
            }
            pq.add(new Soldier(count, i));
        }

        for (int i = 0; i < k; i++) {
            System.out.println("Row"+pq.peek().idx);
            pq.remove();
        }
    }
}
