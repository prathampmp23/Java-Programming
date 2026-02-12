import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class DetectCycle {
    public boolean isCyclic(int V, List<List<Integer>> adj) {
        int[] inDegree = new int[V];
        Queue<Integer> q = new LinkedList<>();

        // Count of visited (processed) nodes
        int visited = 0;

        // Compute in-degrees of all vertices
        for (int u = 0; u < V; u++) {
            for (int v : adj.get(u)) {
                inDegree[v]++;
            }
        }

        // Add all vertices with in-degree 0 to the queue
        for (int u = 0; u < V; u++) {
            if (inDegree[u] == 0) {
                q.add(u);
            }
        }

        // Perform BFS (Topological Sort)
        while (!q.isEmpty()) {
            int u = q.poll();
            visited++;

            // Reduce in-degree of neighbors
            for (int v : adj.get(u)) {
                inDegree[v]--;
                if (inDegree[v] == 0) {
                    // Add to queue when in-degree becomes 0
                    q.add(v);
                }
            }
        }

        // If visited nodes != total nodes, a cycle exists
        return visited != V;
    }

    /*
     * Input: V = 6, adj= [ [1], [2, 5], [3], [4], [1], [ ] ]
     * Output: True
     * 
     * Explanation: The graph contains a cycle: 1 -> 2 -> 3 -> 4 -> 1.
     */
}
