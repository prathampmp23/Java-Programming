package Graphs.G2;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class ConnectedComponents {
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
         * 0
         * / \
         * / \
         * / \
         * 2 1
         * | |
         * | |
         * | |
         * 4 ------ 3
         * \ /
         * \ /
         * \ /
         * 5 ------- 6
         * 
         */

        // null -> empty Arraylist
        for (int i = 0; i < graph.length; i++) {
            graph[i] = new ArrayList<>();
        }

        // store graph info
        // 0 - vertex
        graph[0].add(new Edge(0, 1, 1));
        graph[0].add(new Edge(0, 2, 1));

        // 1 - vertex
        graph[1].add(new Edge(1, 0, 1));
        // graph[1].add(new Edge(1, 3, 1));

        // 2 - vertex
        graph[2].add(new Edge(2, 0, 1));
        // graph[2].add(new Edge(2, 4, 1));

        // 3 - vertex
        // graph[3].add(new Edge(3, 1, 1));
        graph[3].add(new Edge(3, 4, 1));
        graph[3].add(new Edge(3, 5, 1));

        // 4 - vertex
        // graph[4].add(new Edge(4, 2, 1));
        graph[4].add(new Edge(4, 3, 1));
        graph[4].add(new Edge(4, 5, 1));

        // 5 - vertex
        graph[5].add(new Edge(5, 3, 1));
        graph[5].add(new Edge(5, 4, 1));
        graph[5].add(new Edge(5, 6, 1));

        // 6 - vertex
        graph[5].add(new Edge(6, 5, 1));

    }

    public static void bfs(ArrayList<Edge>[] graph) {
        boolean visited[] = new boolean[graph.length];
        for (int i = 0; i < graph.length; i++) {
            if (!visited[i]) {
                bfsUtil(graph, visited);
            }
        }
    }

    // helper function (utility)
    public static void bfsUtil(ArrayList<Edge>[] graph, boolean visited[]) {
        Queue<Integer> q = new LinkedList<>();
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

    public static void dfs(ArrayList<Edge>[] graph) {
        boolean visited[] = new boolean[graph.length];
        for (int i = 0; i < graph.length; i++) {
            if (!visited[i]) {
                dfsUtil(graph, i, visited);
            }
        }
    }

    // helper function (utility)
    public static void dfsUtil(ArrayList<Edge>[] graph, int curr, boolean visited[]) {
        // visited
        System.out.print(curr + " ");
        visited[curr] = true;

        for (int i = 0; i < graph[curr].size(); i++) {
            Edge e = graph[curr].get(i);
            if (!visited[e.destination]) {
                dfsUtil(graph, e.destination, visited);
            }
        }
    }

    // Find no of connected components
    // using matrix of 0s and 1s
    public int findCircleNum(int[][] isConnected) {
        int n = isConnected.length;
        boolean visited[] = new boolean[n];
        int provinces = 0;

        for (int i = 0; i < n; i++) {
            if (!visited[i]) {
                provinces += 1;
                dfs(isConnected, i, visited, n);
            }
        }
        return provinces;
    }

    public void dfs(int[][] isConnected, int city, boolean visited[], int n) {
        visited[city] = true;
        for (int neighbor = 0; neighbor < n; neighbor++) {
            if (isConnected[city][neighbor] == 1 && !visited[neighbor]){
                dfs(isConnected, neighbor, visited, n);
            }
        }
    }
    

    // or if edges is provided
    public int findNumberOfComponent(int V, List<List<Integer>> edges) {

        // Step 1: Build adjacency list
        List<List<Integer>> adj = new ArrayList<>();
        for (int i = 0; i < V; i++) {
            adj.add(new ArrayList<>());
        }

        for (List<Integer> edge : edges) {
            int u = edge.get(0);
            int v = edge.get(1);
            adj.get(u).add(v);
            adj.get(v).add(u); // undirected graph
        }

        // Step 2: DFS to count components
        boolean[] visited = new boolean[V];
        int components = 0;

        for (int i = 0; i < V; i++) {
            if (!visited[i]) {
                components++;
                dfs(i, adj, visited);
            }
        }

        return components;
    }

    private void dfs(int node, List<List<Integer>> adj, boolean[] visited) {
        visited[node] = true;
        for (int neighbor : adj.get(node)) {
            if (!visited[neighbor]) {
                dfs(neighbor, adj, visited);
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
