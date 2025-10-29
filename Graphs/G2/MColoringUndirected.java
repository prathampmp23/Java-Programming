package Graphs.G2;

import java.util.ArrayList;
import java.util.List;

public class MColoringUndirected {
    public static boolean graphColoring(int[][] edges, int m, int n) {
        // Build adjacency list
        List<List<Integer>> adj = new ArrayList<>();
        for (int i = 0; i < n; i++)
            adj.add(new ArrayList<>());

        for (int[] edge : edges) {
            adj.get(edge[0]).add(edge[1]);
            adj.get(edge[1]).add(edge[0]);
        }

        int[] color = new int[n]; // color[i] = color assigned to node i
        return solve(0, adj, color, m, n);
    }

    // Recursive function to assign colors
    public static boolean solve(int node, List<List<Integer>> adj, int[] color, int m, int n) {
        if (node == n)
            return true; // all nodes colored

        for (int c = 1; c <= m; c++) {
            if (isSafe(node, adj, color, c)) {
                color[node] = c; // assign color
                if (solve(node + 1, adj, color, m, n))
                    return true;
                color[node] = 0; // backtrack
            }
        }
        return false;
    }

    // Check if color assignment is safe
    public static boolean isSafe(int node, List<List<Integer>> adj, int[] color, int col) {
        for (int neighbor : adj.get(node))
            if (color[neighbor] == col)
                return false;
        return true;
    }

    public static void main(String[] args) {
        int N = 3, M = 3;
        int Edges[][] = { { 0, 1 }, { 1, 2 }, { 0, 2 } };
        System.out.println(graphColoring(Edges, M, N));
    }
}
