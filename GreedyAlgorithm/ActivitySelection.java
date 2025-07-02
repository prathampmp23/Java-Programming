package GreedyAlgorithm;

import java.util.*;

public class ActivitySelection {
    public static void main(String[] args) {
        int start[] = { 1, 3, 0, 5, 8, 5 };
        int end[] = { 2, 4, 6, 7, 9, 9 };

        // ## If Activities (start,end) are sorted mention

        // // End time basis sorted
        // int maxAct = 0;
        // ArrayList<Integer> ans = new ArrayList<>();

        // // 1st Activity
        // maxAct = 1;
        // ans.add(0);
        // int lastEnd = end[0];

        // for (int i = 1; i < end.length; i++) {
        // if (start[i] >= lastEnd) {
        // maxAct++;
        // ans.add(i);
        // lastEnd = end[i];
        // }
        // }
        // System.out.println("Max Activities = " + maxAct);
        // for (int i = 0; i < ans.size(); i++) {
        // System.out.print("A" + ans.get(i) + " ");
        // }

        // ## If Activities (start,end) are sorted 'not' mention

        // Sorting
        int activities[][] = new int[start.length][3];
        for (int i = 0; i < start.length; i++) {
            activities[i][0] = i;
            activities[i][1] = start[i];
            activities[i][2] = end[i];
        }

        // "Lambda function" -> shortForm functions
        // In Java, Comparator is an interface for sorting Java Objects.
        // A Comparator that defines how the elements should be compared.
        // The lambda function o -> o[2] extracts the third element (o[2]) from each
        // sub-array (which represents the end time of an activity). It acts as the
        // sorting key.
        Arrays.sort(activities, Comparator.comparingDouble(o -> o[2]));

        // End time basis sorted
        int maxAct = 0;
        ArrayList<Integer> ans = new ArrayList<>();

        // 1st Activity
        maxAct = 1;
        ans.add(activities[0][0]);
        int lastEnd = activities[0][0];

        for (int i = 1; i < end.length; i++) {
            if (activities[i][1] >= lastEnd) {
                maxAct++;
                ans.add(activities[i][0]);
                lastEnd = activities[i][2];
            }
        }

        System.out.println("Max Activities = " + maxAct);
        for (int i = 0; i < ans.size(); i++) {
            System.out.print("A" + ans.get(i) + " ");
        }
    }
}
