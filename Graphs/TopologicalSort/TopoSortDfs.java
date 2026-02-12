import java.util.List;
import java.util.Stack;

public class TopoSortDfs {
    public int[] topoSort(int V, List<List<Integer>> adj) {
        int visited[] = new int[V];
        Stack<Integer> st = new Stack<>();

        for (int i = 0; i < V; i++) {
            if (visited[i] == 0) {
                dfs(i, adj, visited, st);
            }
        }
        int ans[] = new int[V];
        int idx = 0;
        while (!st.isEmpty()) {
            ans[idx++] = st.pop();
        }
        return ans;
    }

    public void dfs(int curr, List<List<Integer>> adj, int visited[], Stack<Integer> st) {
        visited[curr] = 1;

        for (int neighbour : adj.get(curr)) {
            if (visited[neighbour] == 0) {
                dfs(neighbour, adj, visited, st);
            }
        }
        st.push(curr);
    }

    /*
     * Input: V = 6, adj = [[ ], [ ], [3], [1], [0,1], [0,2]]
     * Output: [5, 4, 2, 3, 1, 0]
     * 
     * Explanation: A graph may have multiple topological sortings.
     * Node 5 must appear before 0 and 2
     * Node 2 must appear before 3
     * Node 3 must appear before 1
     * Node 4 must appear before 0 and 1
     * 
     * One valid topological order is: [5, 4, 2, 3, 1, 0]
     */
}
