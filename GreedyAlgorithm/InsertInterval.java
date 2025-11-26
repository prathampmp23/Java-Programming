package GreedyAlgorithm;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class InsertInterval {
    public static int[][] insert(int[][] intervals, int[] newInterval) {
        if (intervals == null || intervals.length == 0) {
            return new int[][] { Arrays.copyOf(newInterval, newInterval.length) };
        }

        int n = intervals.length;
        int[][] result = new int[n + 1][2];
        for (int i = 0; i < n; i++) {
            result[i] = Arrays.copyOf(intervals[i], intervals[i].length);
        }
        result[n] = Arrays.copyOf(newInterval, newInterval.length);

        Arrays.sort(result, (a, b) -> (a[0] - b[0]));

        List<int[]> ans = new ArrayList<>();

        for (int i = 0; i < result.length; i++) {
            if (ans.isEmpty() || result[i][0] > ans.get(ans.size() - 1)[1]) {
                ans.add(result[i]);
            } else {
                ans.get(ans.size() - 1)[1] = Math.max(ans.get(ans.size() - 1)[1], result[i][1]);
            }
        }

        return ans.toArray(new int[ans.size()][]);
    }

    public static int[][] insert2(int[][] intervals, int[] newInterval) {
        List<int[]> result = new ArrayList<>();
        int i = 0;
        // first part non overlapping
        while (i < intervals.length && intervals[i][1] < newInterval[0]) {
            result.add(intervals[i]);
            i++;
        }

        // overlapping part in middle
        while (i < intervals.length && intervals[i][0] <= newInterval[1]) {
            newInterval[0] = Math.min(intervals[i][0], newInterval[0]);
            newInterval[1] = Math.max(intervals[i][1], newInterval[1]);
            i++;
        }
        result.add(newInterval);

        // last o=non overlapping part
        while (i < intervals.length) {
            result.add(intervals[i]);
            i++;
        }

        return result.toArray(new int[result.size()][]);
    }

    public static void print2D(int[][] arr) {
        System.out.print("[");
        for (int i = 0; i < arr.length; i++) {
            System.out.print(Arrays.toString(arr[i]));
            if (i != arr.length - 1)
                System.out.print(", ");
        }
        System.out.println("]");
    }

    public static void main(String[] args) {
        int[][] intervals1 = { { 1, 3 }, { 6, 9 } };
        int[] newInterval1 = { 2, 5 };

        int[][] intervals2 = { { 1, 2 }, { 3, 5 }, { 6, 7 }, { 8, 10 }, { 12, 16 } };
        int[] newInterval2 = { 4, 8 };

        System.out.println("Output 1:");
        print2D(insert(intervals1, newInterval1));

        System.out.println("Output 2:");
        print2D(insert(intervals2, newInterval2));
    }
}
