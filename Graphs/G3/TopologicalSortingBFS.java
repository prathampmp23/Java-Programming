package Graphs.G3;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class TopologicalSortingBFS {
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
        graph[2].add(new Edge(2, 3));

        graph[3].add(new Edge(3, 1));

        graph[4].add(new Edge(4, 0));
        graph[4].add(new Edge(4, 1));

        graph[5].add(new Edge(5, 0));
        graph[5].add(new Edge(5, 2));

    }

    // O(V+E)

    public static void claculateIndegree(ArrayList<Edge>[] graph, int indegree[]) {

        for (int i = 0; i < graph.length; i++) {
            int v = i;
            for (int j = 0; j < graph[v].size(); j++) {
                Edge e = graph[v].get(j);
                indegree[e.dest]++;
            }
        }
    }

    public static void topologicalSort(ArrayList<Edge>[] graph) {
        int indegree[] = new int[graph.length];
        claculateIndegree(graph, indegree);
        Queue<Integer> q = new LinkedList<>();

        for (int i = 0; i < indegree.length; i++) {
            if (indegree[i] == 0) {
                q.add(i);
            }
        }

        // BFS
        while (!q.isEmpty()) {
            int curr = q.remove();
            System.out.print(curr + " "); // topological sorting sequence

            for (int j = 0; j < graph[curr].size(); j++) {
                Edge e = graph[curr].get(j);

                indegree[e.dest]--;

                if (indegree[e.dest] == 0) {
                    q.add(e.dest);
                }
            }
        }

        System.out.println();
    }

    @SuppressWarnings("unchecked")
    public static void main(String[] args) {
        int V = 6; // no of vertex

        // Array of Arraylist
        ArrayList<Edge>[] graph = new ArrayList[V];

        createGraph(graph);

        topologicalSort(graph);
    }
}
