import java.util.ArrayList;
import java.util.Arrays;

public class BipartiteGraphDFS {

    class Edge {
        int source;
        int dest;

        public Edge(int src, int dest) {
            this.source = src;
            this.dest = dest;
        }
    }

    public boolean isBipartite(int[][] graph) {
        ArrayList<Edge>[] adjGraph = new ArrayList[graph.length];

        for (int i = 0; i < graph.length; i++) {
            adjGraph[i] = new ArrayList<>();
        }
        for (int i = 0; i < graph.length; i++) {
            for (int j = 0; j < graph[i].length; j++) {
                adjGraph[i].add(new Edge(i, graph[i][j]));
            }
        }

        int colors[] = new int[graph.length];
        for (int i = 0; i < colors.length; i++) {
            colors[i] = -1; // no colors
        }

        for (int i = 0; i < graph.length; i++) {
            if (colors[i] == -1) {
                if (!dfs(i, 0, colors, adjGraph))
                    return false;
            }
        }
        return true;
    }

    public static boolean dfs(int node, int color, int[] colors, ArrayList<Edge>[] graph) {
        colors[node] = color; // source node

        for (int i = 0; i < graph[node].size(); i++) {
            Edge e = graph[node].get(i);

            if (colors[e.dest] == -1) {
                if (dfs(e.dest, 1 - color, colors, graph) == false)
                    return false;
            } else if (colors[e.dest] == color) {
                return false;
            }
        }
        return true;
    }

    // "Optimal" if 2d Array is given
    public boolean isBipartite2(int[][] graph) {
        int V = graph.length;
        int[] colorArray = new int[V];
        Arrays.fill(colorArray, -1);

        for (int i = 0; i < V; i++) {
            if (colorArray[i] == -1) {
                if (!dfs(graph, i, colorArray, 0)) {
                    return false;
                }
            }
        }
        return true;
    }

    private boolean dfs(int[][] graph, int srcNode, int[] colorArray, int color) {
        colorArray[srcNode] = color;

        for (int destNode : graph[srcNode]) {
            if (colorArray[destNode] == -1) {
                if (!dfs(graph, destNode, colorArray, 1 - color)) {
                    return false;
                }
            } else if (colorArray[destNode] == colorArray[srcNode]) {
                return false;
            }
        }

        return true;
    }

    /*
     * Example 1:
     * Input: graph = [[1,2,3],[0,2],[0,1,3],[0,2]]
     * Output: false
     * Explanation: There is no way to partition the nodes into two independent sets
     * such that every edge connects a node in one and a node in the other.
     * 
     * Example 2:
     * Input: graph = [[1,3],[0,2],[1,3],[0,2]]
     * Output: true
     * Explanation: We can partition the nodes into two sets: {0, 2} and {1, 3}.
     */
    public static void main(String[] args) {
        BipartiteGraphDFS bg = new BipartiteGraphDFS();
        int[][] graph1 = {{1,2,3},{0,2},{0,1,3},{0,2}};
        int[][] graph2 = {{1,3},{0,2},{1,3},{0,2}};

        System.out.println(bg.isBipartite2(graph1)); // Output: false
        System.out.println(bg.isBipartite2(graph2)); // Output: true
    }
}