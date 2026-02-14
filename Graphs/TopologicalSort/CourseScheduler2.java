import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class CourseScheduler2 {
    public static int[] findOrder(int numCourses, int[][] prerequisites) {

        List<List<Integer>> graph = new ArrayList<>();

        for (int i = 0; i < numCourses; i++) {
            graph.add(new ArrayList<>());
        }

        // indegree[i] = number of prerequisites required for course i
        int[] indegree = new int[numCourses];

        for (int[] pre : prerequisites) {
            graph.get(pre[1]).add(pre[0]); // edge: pre[1] -> pre[0]
            indegree[pre[0]]++; // increase indegree of course a
        }

        // Queue for BFS (stores courses with no remaining prerequisites)
        Queue<Integer> q = new LinkedList<>();

        // Add all courses with indegree 0 (no prerequisites)
        for (int i = 0; i < numCourses; i++) {
            if (indegree[i] == 0) {
                q.offer(i);
            }
        }

        // Array to store the topological order
        int[] res = new int[numCourses];
        int idx = 0; // index for result array

        // Perform BFS (Kahn's Algorithm)
        while (!q.isEmpty()) {
            int curr = q.poll(); // take course with no prerequisites
            res[idx++] = curr; // add course to result

            // Reduce indegree of dependent courses
            for (int next : graph.get(curr)) {
                if (--indegree[next] == 0) { // if no prerequisites left
                    q.offer(next); // course can now be taken
                }
            }
        }

        // If all courses are included, return result
        // Otherwise, a cycle exists and no valid order is possible
        return idx == numCourses ? res : new int[0];
    }

    public static void main(String[] args) {
        /*
         * Example 1:
         * Input: numCourses = 2, prerequisites = [[1,0]]
         * Output: [0,1]
         * Explanation: There are a total of 2 courses to take. To take course 1 you
         * should have finished course 0. So the correct course order is [0,1].
         * 
         * Example 2:
         * Input: numCourses = 4, prerequisites = [[1,0],[2,0],[3,1],[3,2]]
         * Output: [0,2,1,3]
         * Explanation: There are a total of 4 courses to take. To take course 3 you
         * should have finished both courses 1 and 2. Both courses 1 and 2 should be
         * taken after you finished course 0.
         * So one correct course order is [0,1,2,3]. Another correct ordering is
         * [0,2,1,3].
         */

        int numCourses = 4;
        int[][] prerequisites = { { 1, 0 }, { 2, 0 }, { 3, 1 }, { 3, 2 } };
        int result[] = findOrder(numCourses, prerequisites);
        for (int i : result) {
            System.out.print(i + " ");
        }
    }
}
