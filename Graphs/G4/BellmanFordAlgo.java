package Graphs.G4;

import java.util.ArrayList;

public class BellmanFordAlgo {
    static class Edge {
        int src;
        int dest;
        int wt;

        public Edge(int src, int dest, int wt) {
            this.src = src;
            this.dest = dest;
            this.wt = wt;
        }
    }

    static void createGraph(ArrayList<Edge>[] graph) {

        // null -> empty Arraylist
        for (int i = 0; i < graph.length; i++) {
            graph[i] = new ArrayList<>();
        }

        // store graph info
        graph[0].add(new Edge(0, 1, 2));
        graph[0].add(new Edge(0, 2, 4));

        graph[1].add(new Edge(1, 2, -4));

        graph[2].add(new Edge(2, 3, 2));

        graph[3].add(new Edge(3, 4, 4));

        graph[4].add(new Edge(4, 1, -1));

    }

    static void createGraph2(ArrayList<Edge> graph) {

        // store edge info
        graph.add(new Edge(0, 1, 2));
        graph.add(new Edge(0, 2, 4));
        graph.add(new Edge(1, 2, -4));
        graph.add(new Edge(2, 3, 2));
        graph.add(new Edge(3, 4, 4));
        graph.add(new Edge(4, 1, -1));

    }

    public static void bellmanFordAlgo(ArrayList<Edge>[] graph, int src) {
        int distance[] = new int[graph.length]; // distance[i] -> src to i
        for (int i = 0; i < graph.length; i++) {
            if (i != src) {
                distance[i] = Integer.MAX_VALUE; // +infinity
            }
        }

        // Algorithm
        int V = graph.length;

        // T.c = O(V*E) total

        // T.c = O(V) for this below code
        for (int i = 0; i < V - 1; i++) {
            // T.c = O(E) as each find the edges that are present only
            // get each vertex
            for (int j = 0; j < graph.length; j++) {
                // get there edges
                for (int k = 0; k < graph[i].size(); k++) {
                    Edge e = graph[i].get(k);
                    // u, v , wt
                    int u = e.src;
                    int v = e.dest;
                    int wt = e.wt;

                    // Relaxation step (find shortest distance)
                    if (distance[u] != Integer.MAX_VALUE && distance[u] + wt < distance[v]) {
                        // update distance of src to v
                        distance[v] = distance[u] + wt;
                    }

                }
            }
        }
        // print all src to vertex shortest distance
        for (int i = 0; i < distance.length; i++) {
            System.out.print(distance[i] + " ");
        }
        System.out.println();
    }

    public static void bellmanFordAlgo2(ArrayList<Edge> graph, int src, int V) {
        int distance[] = new int[V]; // distance[i] -> src to i
        for (int i = 0; i < V; i++) {
            if (i != src) {
                distance[i] = Integer.MAX_VALUE; // +infinity
            }
        }

        // Algorithm

        // T.c = O(V*E) total

        // T.c = O(V)
        for (int i = 0; i < V - 1; i++) {
            // T.c = O(E) as each find the edges that are present only
            for (int j = 0; j < graph.size(); j++) {
                // get there edges
                Edge e = graph.get(j);
                // u, v , wt
                int u = e.src;
                int v = e.dest;
                int wt = e.wt;

                // Relaxation step (find shortest distance)
                if (distance[u] != Integer.MAX_VALUE && distance[u] + wt < distance[v]) {
                    // update distance of src to v
                    distance[v] = distance[u] + wt;
                }

            }
        }
        // print all src to vertex shortest distance
        for (int i = 0; i < distance.length; i++) {
            System.out.print(distance[i] + " ");
        }
        System.out.println();
    }

    @SuppressWarnings("unchecked")
    public static void main(String[] args) {
        int V = 5; // no of vertex

        // Array of Arraylist
        ArrayList<Edge>[] graph = new ArrayList[V];

        // ArrayList of edges as there is no use of vertex in this graph
        ArrayList<Edge> graph2 = new ArrayList<>();

        createGraph(graph);
        createGraph2(graph2);

        // with vertex info
        bellmanFordAlgo(graph, 0);

        // with only edge info
        bellmanFordAlgo2(graph2, 0, V);

    }
}
