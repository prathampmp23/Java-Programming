package Heaps;

import java.util.*;

class A1 {
    int sum;
    int i;
    int j;

    A1(int s, int i1, int j1) {
        sum = s;
        i = i1;
        j = j1;
    }
}

class solComparator implements Comparator<A1> {

    public int compare(A1 p1, A1 p2) {

        if (p1.sum < p2.sum)
            return 1;
        else if (p1.sum > p2.sum)
            return -1;
        else
            return 0;
    }
}

public class MaxSumCombination {
    // Brute
    public static int[] solve1(int[] A, int[] B, int C) {
        int ans[] = new int[C];
        int n = A.length;
        
        PriorityQueue<Integer> minHeap = new PriorityQueue<>();

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                int sum = A[i] + B[j];
                if (minHeap.size() < C) {
                    minHeap.offer(sum);
                } else if (sum > minHeap.peek()) {
                    minHeap.poll();
                    minHeap.offer(sum);
                }
            }
        }

        // extract into list and sort descending (non-increasing)
        ArrayList<Integer> result = new ArrayList<>(minHeap);
        result.sort(Collections.reverseOrder());
        int idx = 0;
        while(idx < C) {
            ans[idx] = result.get(idx);
            idx++;
        }
        return ans;
    }

    public static int[] solve2(int[] A, int[] B, int C) {

        int n = A.length;

        PriorityQueue<A1> p = new PriorityQueue<A1>(new solComparator());
        Arrays.sort(A);
        Arrays.sort(B);

        HashSet<String> hs = new HashSet<>();

        p.add(new A1(A[n - 1] + B[n - 1], n - 1, n - 1));
        hs.add(new String((n - 1) + " " + (n - 1)));

        int i = n - 1, j = n - 1;

        int ans[] = new int[C];
        int y = 0;

        for (int p1 = 0; p1 < C; p1++) {
            ans[y] = p.peek().sum;
            y++;

            i = p.peek().i;
            j = p.peek().j;
            p.poll();

            if (i > 0 && j > 0) {
                if (!hs.contains(new String((i - 1) + " " + j))) {
                    p.add(new A1(A[i - 1] + B[j], i - 1, j));
                    hs.add(new String((i - 1) + " " + j));

                }

                if (!hs.contains(new String(i + " " + (j - 1)))) {
                    p.add(new A1(A[i] + B[j - 1], i, j - 1));

                    hs.add(new String(i + " " + (j - 1)));
                }

            }
        }
        return ans;
    }

    public static void main(String[] args) {
        int[] A = {1,4,2,3};
        int[] B = {2,5,1,6};
        int ans1[] = solve1(A, B, 4); // [10, 9, 9, 8]
        for(int a: ans1) {
            System.out.print(a + " ");
        }

        System.out.println();

        int[] A2 = {3,2};
        int[] B2 = {1,4};
        int ans2[] = solve2(A2, B2, 2); // [7, 6]
        for(int a: ans2) {
            System.out.print(a+ " ");
        }
    }
}