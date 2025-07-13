package Graphs.G1;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class BFS {
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

    static void createGraph(ArrayList<Edge>[] graph) {

        /*
         *            0
         *           / \
         *         /    \ 
         *       /       \
         *      2        1
         *      |        |
         *      |        |
         *      |        |
         *      4 ------ 3
         *      \       /
         *       \    /
         *        \  /
         *         5 ------- 6
         *        
         */
        // null -> empty Arraylist
        for (int i = 0; i < graph.length; i++) {
            graph[i] = new ArrayList<>();
        }

        // store edges info
        // 0 - vertex
        graph[0].add(new Edge(0, 1, 1));
        graph[0].add(new Edge(0, 2, 1));

        // 1 - vertex
        graph[1].add(new Edge(1, 0, 1));
        graph[1].add(new Edge(1, 3, 1));

        // 2 - vertex
        graph[2].add(new Edge(2, 0, 1));
        graph[2].add(new Edge(2, 4, 1));

        // 3 - vertex
        graph[3].add(new Edge(3, 1, 1));
        graph[3].add(new Edge(3, 4, 1));
        graph[3].add(new Edge(3, 5, 1));

        // 4 - vertex
        graph[4].add(new Edge(4, 2, 1));
        graph[4].add(new Edge(4, 3, 1));
        graph[4].add(new Edge(4, 5, 1));

        // 5 - vertex
        graph[5].add(new Edge(5, 3, 1));
        graph[5].add(new Edge(5, 4, 1));
        graph[5].add(new Edge(5, 6, 1));

        // 6 - vertex
        graph[5].add(new Edge(6, 5, 1));

    }

    // T.c = O(V+E)
    // The value (Vertex,Edge) which is greater is control the T.C of code
    public static void bfs(ArrayList<Edge>[] graph) {
        Queue<Integer> q = new LinkedList<>();
        boolean visited[] = new boolean[graph.length];

        q.add(0); // source = 0

        while (!q.isEmpty()) {
            int curr = q.remove();

            // if not visited before
            if (!visited[curr]) { // visit curr
                System.out.print(curr + " "); // print
                visited[curr] = true; // mark visited true

                // to find vertex neighbours
                for (int i = 0; i < graph[curr].size(); i++) {
                    Edge e = graph[curr].get(i);
                    q.add(e.destination);
                }
            }
        }
    }

    @SuppressWarnings("unchecked")
    public static void main(String[] args) {
        int V = 7; // no of vertex

        // Array of Arraylist
        ArrayList<Edge>[] graph = new ArrayList[V];

        createGraph(graph);
        bfs(graph);
    }
}
