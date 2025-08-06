package Arrays1D;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class MergeOverlappingSubIntervals {

    // Brute Force - O(logN) + O(2N)
    public static int[][] merge(int[][] intervals) {
        if (intervals == null || intervals.length == 0)
            return new int[0][0];

        // Sort intervals by start time
        Arrays.sort(intervals, (a, b) -> Integer.compare(a[0], b[0]));

        List<int[]> merged = new ArrayList<>();
        int n = intervals.length;

        for (int i = 0; i < n; i++) {
            int start = intervals[i][0];
            int end = intervals[i][1];

            // Skip if this interval is already covered by the last merged one
            if (!merged.isEmpty() && end <= merged.get(merged.size() - 1)[1]) {
                continue;
            }

            // Check and merge overlapping intervals
            for (int j = i + 1; j < n; j++) {
                if (intervals[j][0] <= end) {
                    end = Math.max(end, intervals[j][1]);
                } else {
                    break;
                }
            }

            merged.add(new int[] { start, end });
        }

        return merged.toArray(new int[merged.size()][]);
    }

    // optimal - O(logN) + O(N)
    public static int[][] merge2(int[][] intervals) {
        if (intervals == null || intervals.length == 0)
            return new int[0][0];

        // Sort intervals by starting point
        Arrays.sort(intervals, (a, b) -> Integer.compare(a[0], b[0]));

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

    public static void main(String[] args) {
        int intervals[][] = { { 1, 3 }, { 2, 6 }, { 8, 10 }, { 15, 18 } };

        // Call the merge function
        int[][] result = merge(intervals);

        // Print Output
        System.out.println("Merged Intervals:");
        for (int[] interval : result) {
            System.out.println(Arrays.toString(interval));
        }
    }
}
