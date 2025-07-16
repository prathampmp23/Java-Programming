package Graphs.G5;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class CheapestFlightWithinKstops {
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

    static void createGraph(ArrayList<Edge> graph[], int flights[][]) {
        // null -> empty Arraylist
        for (int i = 0; i < graph.length; i++) {
            graph[i] = new ArrayList<>();
        }

        for (int i = 0; i < flights.length; i++) {
            int src = flights[i][0];
            int dest = flights[i][1];
            int wt = flights[i][2];

            Edge e = new Edge(src, dest, wt);

            // store graph neighbour at its src
            graph[src].add(e);
        }

    }

    static class Info {
        int vertex; // vertex value is store
        int cost; // cost is stored between src to dest
        int stops; // stops is stored between src to dest

        public Info(int vertex, int cost, int stops) {
            this.vertex = vertex;
            this.cost = cost;
            this.stops = stops;
        }
    }

    // T.c = O(V+ E logV)
    // E logV is due to sorting of pairs in Priority queue
    @SuppressWarnings("unchecked")
    public static int cheapestFlight(int flights[][], int V, int src, int dest, int k) {
        ArrayList<Edge> graph[] = new ArrayList[V];
        createGraph(graph, flights);

        int distance[] = new int[V]; // distance[i] -> src to i
        for (int i = 0; i < V; i++) {
            if (i != src) {
                distance[i] = Integer.MAX_VALUE; // +infinity
            }
        }

        Queue<Info> q = new LinkedList<>();
        q.add(new Info(src, 0, 0));

        // Bfs
        while (!q.isEmpty()) {
            Info curr = q.remove(); // remove front
            if (curr.stops > k) {
                break;
            }
            for (int i = 0; i < graph[curr.vertex].size(); i++) {
                Edge e = graph[curr.vertex].get(i);
                // int u = e.src;
                int v = e.dest;
                int wt = e.wt;

                // if (distance[u] != Integer.MAX_VALUE && distance[u] + wt < distance[v] && curr.stops <= k) {
                // distance[u] replace to curr.cost as distance[] may give wrong ans as it store min cost 
                if (curr.cost + wt < distance[v] && curr.stops <= k) {
                    // update distance of src to v (Relaxation step)
                    distance[v] = curr.cost + wt;
                    q.add(new Info(v, distance[v], curr.stops + 1));
                }
            }
        }

        if (distance[dest] == Integer.MAX_VALUE) {
            return -1;
        } else {
            return distance[dest];
        }
    }

    public static void main(String[] args) {
        int V = 4; // no of vertex

        int flights[][] = { { 0, 1, 100 }, { 1, 2, 100 }, { 2, 0, 100 }, { 1, 3, 600 }, { 2, 3, 200 } };
        int src = 0, dest = 3, k = 1;

        System.out.println("Cheapest Flight Within K stops = "+cheapestFlight(flights, V, src, dest, k));

    }
}
