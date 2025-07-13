package Graphs.G1;

import java.util.ArrayList;

public class AdjancencyListGraph {

    static class Edge {
        int source;
        int destination;
        int weight;

        public Edge(int src, int dest, int wt) {
            this.source = src;
            this.destination = dest;
            this.weight = wt;
        }
    }

    @SuppressWarnings("unchecked")
    public static void main(String[] args) {
        /*
         *      (5)
         *   0 ------ 1
         *           / \
         *     (1) /    \ (3) 
         *       /       \
         *      2 ------ 3
         *      |   (1)
         *  (2) |
         *      |
         *      4
         */
        int V = 5; // no of vertex

        // Array of Arraylist
        ArrayList<Edge>[] graph = new ArrayList[V];

        // null -> empty Arraylist
        for (int i = 0; i < V; i++) {
            graph[i] = new ArrayList<>();
        }

        // store edges info
        // 0 - vertex
        graph[0].add(new Edge(0, 1, 5)); // 0 ---- 1

        // 1 - vertex
        graph[1].add(new Edge(1, 0, 5)); // 0 ---- 1
        graph[1].add(new Edge(1, 2, 1)); // 1 ---- 2
        graph[1].add(new Edge(1, 3, 3)); // 1 ---- 3

        // 2 - vertex
        graph[2].add(new Edge(2, 1, 1)); // 2 ---- 1
        graph[2].add(new Edge(2, 3, 1)); // 2 ---- 3
        graph[2].add(new Edge(2, 4, 2)); // 2 ---- 4

        // 3 - vertex
        graph[3].add(new Edge(3, 1, 3)); // 3 ---- 1
        graph[3].add(new Edge(3, 2, 1)); // 3 ---- 2

        // 4 - vertex
        graph[4].add(new Edge(4, 2, 2)); // 4 ---- 2

        // 2's Neighbour
        System.out.println("2's Neighbour");
        for (int i = 0; i < graph[2].size(); i++) {
            Edge e = graph[2].get(i); // src , dest, wt
            System.out.println(e.destination);
        }

        System.out.println();

        // 3's Neighbour
        System.out.println("3's Neighbour");
        for (int i = 0; i < graph[3].size(); i++) {
            Edge e = graph[3].get(i); // src , dest, wt
            System.out.println(e.destination);
        }

    }
}