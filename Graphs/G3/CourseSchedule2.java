package Graphs.G3;

import java.util.*;

public class CourseSchedule2 {
    
    public int[] findOrder(int numCourses, int[][] prerequisites) {

        // Adjacency list where graph.get(i) contains courses
        // that depend on course i (i -> next course)
        ArrayList<ArrayList<Integer>> graph = new ArrayList<>();

        // Initialize adjacency list for each course
        for (int i = 0; i < numCourses; i++)
            graph.add(new ArrayList<>());

        // indegree[i] = number of prerequisites required for course i
        int[] indegree = new int[numCourses];

        // Build the graph and compute indegrees
        // prerequisite pair [a, b] means b must be taken before a
        for (int[] pre : prerequisites) {
            graph.get(pre[1]).add(pre[0]); // edge: pre[1] -> pre[0]
            indegree[pre[0]]++;             // increase indegree of course a
        }

        // Queue for BFS (stores courses with no remaining prerequisites)
        Queue<Integer> q = new LinkedList<>();

        // Add all courses with indegree 0 (no prerequisites)
        for (int i = 0; i < numCourses; i++)
            if (indegree[i] == 0)
                q.offer(i);

        // Array to store the topological order
        int[] res = new int[numCourses];
        int idx = 0; // index for result array

        // Perform BFS (Kahn's Algorithm)
        while (!q.isEmpty()) {
            int curr = q.poll();   // take course with no prerequisites
            res[idx++] = curr;     // add course to result

            // Reduce indegree of dependent courses
            for (int next : graph.get(curr))
                if (--indegree[next] == 0) // if no prerequisites left
                    q.offer(next);         // course can now be taken
        }

        // If all courses are included, return result
        // Otherwise, a cycle exists and no valid order is possible
        return idx == numCourses ? res : new int[0];
    }


}
