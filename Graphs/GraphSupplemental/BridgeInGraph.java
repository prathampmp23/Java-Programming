package Graphs.GraphSupplemental;

import java.util.ArrayList;

public class BridgeInGraph {
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
        graph[0].add(new Edge(0, 1));
        graph[0].add(new Edge(0, 2));
        graph[0].add(new Edge(0, 3));

        graph[1].add(new Edge(1, 0));
        graph[1].add(new Edge(1, 2));
        
        graph[2].add(new Edge(2, 0));
        graph[2].add(new Edge(2, 1));

        graph[3].add(new Edge(3, 0));
        graph[3].add(new Edge(3, 4));
        // graph[3].add(new Edge(3, 5));
        
        graph[4].add(new Edge(4, 3));
        // graph[4].add(new Edge(4, 5));

        // graph[5].add(new Edge(5, 3));
        // graph[5].add(new Edge(5, 4));
    }

    public static void dfs(ArrayList<Edge> graph[], int curr, int parent, int dt[], int low[], boolean visited[], int time) {
        visited[curr] = true;
        dt[curr] = low[curr] = ++time;

        for (int i = 0; i < graph[curr].size(); i++) {
            Edge e = graph[curr].get(i);
            int neighbour = e.dest;
            if (parent == neighbour) {
                continue;
            } else if (!visited[neighbour]) {
                dfs(graph, neighbour, curr, dt, low, visited, time);
                low[curr] = Math.min(low[curr], low[neighbour]);

                if (dt[curr] < low[neighbour]) {
                    System.out.println("Bridge : "+ curr +" ----- " + neighbour );
                }
            } else {
                low[curr] = Math.min(low[curr], dt[neighbour]);
            }
        }
    }

    public static void tarjanBridge(ArrayList<Edge> graph[], int V) {
        int dt[]  = new int[V];
        int low[]  = new int[V];

        int time = 0;
        boolean visited[] = new boolean[V];

        for (int i = 0; i < V; i++) {
            if (!visited[i]) {
                dfs(graph, i, -1, dt, low, visited, time);
            }
        }
    }

    @SuppressWarnings("unchecked")
    public static void main(String[] args) {
        int V = 5; // no of vertex

        // Array of Arraylist
        ArrayList<Edge> graph[] = new ArrayList[V];
        createGraph(graph);

        tarjanBridge(graph, V);
    }
}
