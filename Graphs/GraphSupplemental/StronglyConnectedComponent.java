package Graphs.GraphSupplemental;

import java.util.ArrayList;
import java.util.Stack;

public class StronglyConnectedComponent {
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

        // store graph info
        graph[0].add(new Edge(0, 2));
        graph[0].add(new Edge(0, 3));

        graph[1].add(new Edge(1, 0));

        graph[2].add(new Edge(2, 1));

        graph[3].add(new Edge(3, 4));

    }

    // topological Sorting
    public static void topologicalSortUtil(ArrayList<Edge>[] graph, int curr, boolean[] visited, Stack<Integer> s) {
        visited[curr] = true;

        // for all neighbours
        for (int i = 0; i < graph[curr].size(); i++) {
            Edge e = graph[curr].get(i);
            if (!visited[e.dest]) {
                topologicalSortUtil(graph, e.dest, visited, s);
            }
        }

        s.push(curr);
    }

    // DFS
    public static void dfs(ArrayList<Edge>[] graph, int curr, boolean visited[]) {
        // visited
        System.out.print(curr + " ");
        visited[curr] = true;

        for (int i = 0; i < graph[curr].size(); i++) {
            Edge e = graph[curr].get(i);
            if (!visited[e.dest]) {
                dfs(graph, e.dest, visited);
            }
        }

    }

    @SuppressWarnings("unchecked")
    public static void kosaraju(ArrayList<Edge> graph[], int V) {
        // Step 1
        Stack<Integer> s = new Stack<>();
        boolean visited[] = new boolean[V];

        for (int i = 0; i < graph.length; i++) {
            // not visited
            if (!visited[i]) {
                topologicalSortUtil(graph, i, visited, s); // call modified DFS
            }
        }

        // Step 2
        ArrayList<Edge> transpose[] = new ArrayList[V];
         for (int i = 0; i < transpose.length; i++) {
            visited[i] = false;
            transpose[i] = new ArrayList<>();
        }

        for (int i = 0; i < V; i++) {
            for (int j = 0; j < graph[i].size(); j++) {
                Edge e = graph[i].get(j); // src -> dest
                // reverse edge
                transpose[e.dest].add(new Edge(e.dest, e.src)); // dest -> src
            }
        }

        // Step 3
        while (!s.isEmpty()) {
            int curr = s.pop();
            if (!visited[curr]) {
                System.out.print("Strongly connected components (SCC) -> ");
                dfs(transpose, curr, visited); // pass transposed graph
                System.out.println();
            }
        }

    }

    @SuppressWarnings("unchecked")
    public static void main(String[] args) {
        int V = 5; // no of vertex

        // Array of Arraylist
        ArrayList<Edge> graph[] = new ArrayList[V];
        createGraph(graph);
        kosaraju(graph, V);
    }
}
