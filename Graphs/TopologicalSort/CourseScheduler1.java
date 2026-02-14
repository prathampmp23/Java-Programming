import java.util.*;

public class CourseScheduler1 {
    public static boolean canFinish(int numCourses, int[][] prerequisites) {
        List<List<Integer>> graph = new ArrayList<>();

        for (int i = 0; i < numCourses; i++) {
            graph.add(new ArrayList<>());
        }

        int[] indegree = new int[numCourses];
        for (int[] pre : prerequisites) {
            graph.get(pre[1]).add(pre[0]); // edge: pre[1] -> pre[0]
            indegree[pre[0]]++; // increase indegree of course a
        }
        Queue<Integer> q = new LinkedList<>();
        for (int i = 0; i < numCourses; i++) {
            if (indegree[i] == 0) {
                q.offer(i);
            }
        }

        int[] topoSort = new int[numCourses];
        int idx = 0;

        while (!q.isEmpty()) {
            int curr = q.poll(); // take course with no prerequisites
            topoSort[idx++] = curr;

            for (int next : graph.get(curr)) {
                if (--indegree[next] == 0) {// if no prerequisites left
                    q.offer(next); // course can now be taken
                }
            }
        }
        return idx == numCourses ? true : false;
    }

    public static void main(String[] args) {

        /*
         * There are a total of numCourses courses you have to take, labeled from 0 to
         * numCourses - 1. You are given an array prerequisites where prerequisites[i] =
         * [ai, bi] indicates that you must take course bi first if you want to take
         * course ai.
         * 
         * Example 1:
         * Input: numCourses = 2, prerequisites = [[1,0]]
         * Output: true
         * Explanation: There are a total of 2 courses to take.
         * To take course 1 you should have finished course 0. So it is possible.
         * 
         * Example 2:
         * Input: numCourses = 2, prerequisites = [[1,0],[0,1]]
         * Output: false
         * Explanation: There are a total of 2 courses to take.
         * To take course 1 you should have finished course 0, and to take course 0 you
         * should also have finished course 1. So it is impossible.
         */
        
        int numCourses = 2;
        int[][] prerequisites1 = { { 1, 0 } };
        int[][] prerequisites2 = { { 1, 0 }, { 0, 1 } };
        System.out.println(canFinish(numCourses, prerequisites1));
        System.out.println(canFinish(numCourses, prerequisites2));
    }
}
