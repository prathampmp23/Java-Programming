package GreedyAlgorithm;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class MergeIntervals {
    public static int[][] merge(int[][] intervals) {
        if (intervals == null || intervals.length == 0)
            return new int[0][0];

        // Sort intervals by starting point
        Arrays.sort(intervals, (a, b) -> (a[0] - b[0]));

        List<int[]> ans = new ArrayList<>();

        for (int i = 0; i < intervals.length; i++) {
            // If ans is empty or current interval doesn't overlap with the last one
            if (ans.isEmpty() || intervals[i][0] > ans.get(ans.size() - 1)[1]) {
                ans.add(intervals[i]);
            } else {
                // Overlap: merge with last interval in ans
                ans.get(ans.size() - 1)[1] = Math.max(ans.get(ans.size() - 1)[1], intervals[i][1]);
            }
        }

        return ans.toArray(new int[ans.size()][]);
    }

    public static void print2D(int[][] arr) {
        System.out.print("[");
        for (int i = 0; i < arr.length; i++) {
            System.out.print(Arrays.toString(arr[i]));
            if (i != arr.length - 1) System.out.print(", ");
        }
        System.out.println("]");
    }

    public static void main(String[] args) {
        int[][] intervals1 = { {1,3}, {2,6}, {8,10}, {15,18} };

        int[][] intervals2 = { {1,4}, {4,5} };

        System.out.println("Output 1:");
        print2D(merge(intervals1));

        System.out.println("Output 2:");
        print2D(merge(intervals2));
    }
}
