package Graphs.G2;

import java.util.ArrayList;

public class CycleDetectionUndirectG {
    static class Edge {
        int src;
        int dest;

        public Edge(int src, int dest) {
            this.src = src;
            this.dest = dest;
        }
    }

    static void createGraph(ArrayList<Edge>[] graph) {

        // null -> empty Arraylist
        for (int i = 0; i < graph.length; i++) {
            graph[i] = new ArrayList<>();
        }

        /*
         *           0 - - - - - 3
         *         / |           |
         *       /   |           |
         *     /     |           |
         *   1       |           4
         *     \     |
         *      \    |
         *       \   |
         *         2
         * 
         */

        // store graph info
        // 0 - vertex
        graph[0].add(new Edge(0, 1));
        // graph[0].add(new Edge(0, 2));
        graph[0].add(new Edge(0, 3));

        // 1 - vertex
        graph[1].add(new Edge(1, 0));
        graph[1].add(new Edge(1, 2));

        // 2 - vertex
        // graph[2].add(new Edge(2, 0));
        graph[2].add(new Edge(2, 1));

        // 3 - vertex
        graph[3].add(new Edge(3, 0));
        graph[3].add(new Edge(3, 4));

        // 4 - vertex
        graph[4].add(new Edge(4, 3));

    }

    // O(V+E)
    public static boolean detectCycle(ArrayList<Edge>[] graph) {
        boolean visited[] = new boolean[graph.length];
        for (int i = 0; i < graph.length; i++) {
            if (!visited[i]) {
                // cycle exist in one of the parts
                if (detectCycleUtil(graph, i, -1, visited)) {
                    return true;
                }
            }
        }
        return false;
    }

    // helper function (utility)
    public static boolean detectCycleUtil(ArrayList<Edge>[] graph, int curr, int parent, boolean visited[]) {
        // visited
        visited[curr] = true;

        for (int i = 0; i < graph[curr].size(); i++) {
            Edge e = graph[curr].get(i);

            // Case 3:
            // check cycle exist for neighbour
            if (!visited[e.dest]) {
                if (detectCycleUtil(graph, e.dest, curr, visited)) {
                    return true;
                }
            }
            // Case 1:
            else if (visited[e.dest] && e.dest != parent) {
                // always cycle exist
                return true;
            }
            // Case 2:
            // do nothing continue
        }
        return false;
    }

    @SuppressWarnings("unchecked")
    public static void main(String[] args) {
        int V = 5; // no of vertex

        // Array of Arraylist
        ArrayList<Edge>[] graph = new ArrayList[V];

        createGraph(graph);

        System.out.println(detectCycle(graph));
    }
}
