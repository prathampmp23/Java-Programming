package Graphs.G2;

import java.util.ArrayList;

public class CycleDetectionDirectG {
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

        // cycle graph

         /*
         *           0 < - - - - 1
         *         ^ |           
         *       /   |           
         *     /     |           
         *   3       |           
         *    ^      |
         *     \    |
         *      \  v
         *        2
         * 
         */
        // store graph info
        // 0 - vertex
        graph[0].add(new Edge(0, 2));

        // 1 - vertex
        graph[1].add(new Edge(1, 0));

        // 2 - vertex
        // graph[2].add(new Edge(2, 0));
        graph[2].add(new Edge(2, 3));

        // 3 - vertex
        graph[3].add(new Edge(3, 0));

        // No cycle graph
        // 0 - vertex
        // graph[0].add(new Edge(0, 1));
        // graph[0].add(new Edge(0, 2));

        // // 1 - vertex
        // graph[1].add(new Edge(1, 3));

        // // 2 - vertex
        // graph[2].add(new Edge(2, 3));

    }

    // O(V+E)
    public static boolean isCycle(ArrayList<Edge>[] graph) {
        boolean visited[] = new boolean[graph.length];
        boolean stack[] = new boolean[graph.length];

        for (int i = 0; i < graph.length; i++) {
            if (!visited[i]) {
                // cycle exist in one of the parts
                if (isCycleUtil(graph, i, visited, stack)) {
                    return true;
                }
            }
        }
        return false;
    }

    // helper function (utility)
    public static boolean isCycleUtil(ArrayList<Edge>[] graph, int curr, boolean visited[], boolean stack[]) {
        // visited
        visited[curr] = true;
        stack[curr] = true;

        for (int i = 0; i < graph[curr].size(); i++) {
            Edge e = graph[curr].get(i);

            // cycle if neighbour already present in stack
            if (stack[e.dest]) {
                return true;
            }
            // if neighbour already not present
            if (!visited[e.dest] && isCycleUtil(graph, e.dest, visited, stack)) {
                return true; // if return cycle
            }
        }
        stack[curr] = false;
        return false;
    }

    @SuppressWarnings("unchecked")
    public static void main(String[] args) {
        int V = 4; // no of vertex

        // Array of Arraylist
        ArrayList<Edge>[] graph = new ArrayList[V];

        createGraph(graph);

        System.out.println(isCycle(graph));
    }
}
