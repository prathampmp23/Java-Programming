package Heaps;

import java.util.PriorityQueue;

public class NearestCars {

    static class Point implements Comparable<Point> {
        int x;
        int y;
        int distSq;
        int idx;

        public Point(int x, int y, int distSq, int idx) {
            this.x = x;
            this.y = y;
            this.distSq = distSq;
            this.idx = idx;
        }

        @Override
        public int compareTo(Point p2) {
            // sorting in ascending order
            return this.distSq - p2.distSq;
        }
    }

    public static void main(String[] args) {
        int points[][] = { { 3, 3 }, { 5, -1 }, { -2, 4 } };
        int k = 2;

        PriorityQueue<Point> pq = new PriorityQueue<>();

        for (int i = 0; i < points.length; i++) {
            int distSq = (points[i][0] * points[i][0]) + (points[i][1] * points[i][1]);
            pq.add(new Point(points[i][0], points[i][1], distSq, i));
        }

        // nearest k cars
        for (int i = 0; i < k; i++) {
            System.out.println("C" + pq.peek().idx);
            pq.remove();
        }
    }
}
