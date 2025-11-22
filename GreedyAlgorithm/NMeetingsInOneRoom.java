package GreedyAlgorithm;

import java.util.Arrays;
import java.util.Comparator;

public class NMeetingsInOneRoom {
    public static int maxMeetings(int[] start, int[] end) {
        int activities[][] = new int[start.length][3];
        for (int i = 0; i < start.length; i++) {
            activities[i][0] = i;
            activities[i][1] = start[i];
            activities[i][2] = end[i];
        }
        Arrays.sort(activities, Comparator.comparingDouble(o -> o[2]));

        int maxAct = 1;
        int lastEnd = activities[0][2];

        for (int i = 1; i < end.length; i++) {
            if (activities[i][1] > lastEnd) {
                maxAct++;
                lastEnd = activities[i][2];
            }
        }
        return maxAct;
    }

    public static void main(String[] args) {
        int start[] = { 1, 3, 0, 5, 8, 5 };
        int end[] = { 2, 4, 6, 7, 9, 9 };

        System.out.println(maxMeetings(start, end));
        int start1[] = { 10, 12, 20 };
        int end1[] = { 20, 25, 30 };

        System.out.println(maxMeetings(start1, end1));
    }
}
