package Graphs.G1;

import java.util.ArrayList;

public class HasPath {
    static class Edge {
        int source;
        int dest;
        int weight;

        public Edge(int src, int dest, int wt) {
            this.source = src;
            this.dest = dest;
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
    public static boolean hasPath(ArrayList<Edge>[] graph, int src, int dist, boolean visited[]) {
        if (src == dist) {
            return true;
        }
        // visited
        visited[src] = true;

        for (int i = 0; i < graph[src].size(); i++) {
            Edge e = graph[src].get(i);
            // e.dest -> neighbour
            if (!visited[e.dest] && hasPath(graph, e.dest, dist, visited)) {
                return true;
            }
        }
        return false;
    }

    @SuppressWarnings("unchecked")
    public static void main(String[] args) {
        int V = 7; // no of vertex

        // Array of Arraylist
        ArrayList<Edge>[] graph = new ArrayList[V];

        createGraph(graph);
        if (hasPath(graph, 0, 5, new boolean[V])) {
            System.out.println("Path exist");
        } else {
            System.out.println("Path Not exist");
        }
    }
}
