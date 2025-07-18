package Graphs.GraphSupplemental;

import java.util.ArrayList;

public class ArticulationPoint {
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

    // T.c = O(V+E)
    public static void dfs(ArrayList<Edge> graph[], int curr, int parent, int dt[], int low[], boolean visited[], int time, boolean ArticulationPoint[]) {
        visited[curr] = true;
        dt[curr] = low[curr] = ++time;
        int children = 0;

        for (int i = 0; i < graph[curr].size(); i++) {
            Edge e = graph[curr].get(i);
            int neighbour = e.dest;

            if (parent == neighbour) {
                continue;
            } else if (!visited[neighbour]) {
                dfs(graph, neighbour, curr, dt, low, visited, time, ArticulationPoint);
                low[curr] = Math.min(low[curr], low[neighbour]);

                // articulation point
                if (parent != -1 && dt[curr] <= low[neighbour]) {
                    // System.out.println("Articulation point : " + curr);
                    ArticulationPoint[curr] = true;
                }
                children++;
            } else {
                low[curr] = Math.min(low[curr], dt[neighbour]);
            }
        }

        if (parent == -1 && children > 1) {
            // System.out.println("Articulation point : " + curr);
            ArticulationPoint[curr] = true;
        }
    }

    public static void getArticulationPoint(ArrayList<Edge> graph[], int V) {
        int dt[] = new int[V];
        int low[] = new int[V];

        int time = 0;
        boolean visited[] = new boolean[V];
        boolean ArticulationPoint[] = new boolean[V]; // to track articulation point (duplicates dont add)

        for (int i = 0; i < V; i++) {
            if (!visited[i]) {
                dfs(graph, i, -1, dt, low, visited, time, ArticulationPoint);
            }
        }

        // t0 print all Articulation points
        for (int i = 0; i < ArticulationPoint.length; i++) {
            if (ArticulationPoint[i]) {
                System.out.println("Articulation point = " + i + " ");
            }
        }
    }

    @SuppressWarnings("unchecked")
    public static void main(String[] args) {
        int V = 5; // no of vertex

        // Array of Arraylist
        ArrayList<Edge> graph[] = new ArrayList[V];
        createGraph(graph);

        getArticulationPoint(graph, V);
    }
}
