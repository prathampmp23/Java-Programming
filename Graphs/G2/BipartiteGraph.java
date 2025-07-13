package Graphs.G2;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class BipartiteGraph {
    static class Edge {
        int source;
        int dest;

        public Edge(int src, int dest) {
            this.source = src;
            this.dest = dest;
        }
    }

    static void createGraph(ArrayList<Edge>[] graph) {

        /*
         *             0
         *           /   \
         *         /      \ 
         *       /         \
         *      1           2
         *      |          |
         *      |         |
         *      |        |
         *      3 - - - 4
         *        
         */
        // null -> empty Arraylist
        for (int i = 0; i < graph.length; i++) {
            graph[i] = new ArrayList<>();
        }

        // store edges info
        // 0 - vertex
        graph[0].add(new Edge(0, 1));
        graph[0].add(new Edge(0, 2));

        // 1 - vertex
        graph[1].add(new Edge(1, 0));
        graph[1].add(new Edge(1, 3));

        // 2 - vertex
        graph[2].add(new Edge(2, 0));
        graph[2].add(new Edge(2, 4));

        // 3 - vertex
        graph[3].add(new Edge(3, 1));
        // graph[3].add(new Edge(3, 4));

        // 4 - vertex
        graph[4].add(new Edge(4, 2));
        // graph[4].add(new Edge(4, 3));

    }

    // T.c = O(V+E)
    public static boolean isBiPartite(ArrayList<Edge>[] graph) {
        int color[] = new int[graph.length];
        for (int i = 0; i < color.length; i++) {
            color[i] = -1; // no color
        }

        Queue<Integer> q = new LinkedList<>();
        for (int i = 0; i < graph.length; i++) {
            if (color[i] == -1) {
                q.add(i);
                color[i] = 0; // yellow
                while (!q.isEmpty()) {
                    int curr = q.remove();
                    for (int j = 0; j < graph[curr].size(); j++) {
                        Edge e = graph[curr].get(j);
                        if (color[e.dest] == -1) {
                            int nextColor = color[curr] == 0 ? 1 : 0;
                            color[e.dest] = nextColor;
                            q.add(e.dest);
                        } else if (color[e.dest] == color[curr]) {
                            return false; // not bipartite
                        }
                    }
                }
            }
        }

        return true;
    }

    @SuppressWarnings("unchecked")
    public static void main(String[] args) {
        int V = 5; // no of vertex

        // Array of Arraylist
        ArrayList<Edge>[] graph = new ArrayList[V];

        createGraph(graph);

        System.out.println(isBiPartite(graph));
    }
}
