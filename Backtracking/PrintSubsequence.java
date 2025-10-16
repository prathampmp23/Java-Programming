package Backtracking;

import java.util.ArrayList;

public class PrintSubsequence {
    public static void printS(int idx, ArrayList<Integer> ds, int s, int sum, int[] arr, int n) {
        // Base condition
        if (idx == n) {
            if (s == sum) {
                for (int it : ds) {
                    System.out.print(it + " ");
                }
                System.out.println();
            }
            return;
        }

        // Pick the current element
        ds.add(arr[idx]);
        s += arr[idx];
        printS(idx + 1, ds, s, sum, arr, n);

        // Backtrack (undo the pick)
        s -= arr[idx];
        ds.remove(ds.size() - 1);

        // Not pick the current element
        printS(idx + 1, ds, s, sum, arr, n);
    }

    public static int printSubSquence(int idx, int s, int sum, int[] arr, int n) {
        // Base condition
        // strictly done if condition is not satisfied as it contains positive only 
        if (s > sum) {
            return 0;
        }
        if (idx == n) {
            // condition satisfied
            if (sum == s) {
                return 1;
            } else { // condition not satisfied
                return 0;
            }
        }
        // Pick the current element
        s += arr[idx];
        int l = printSubSquence(idx + 1, s, sum, arr, n);
        // Backtrack (undo the pick)
        s -= arr[idx];
        // Not pick the current element
        int r = printSubSquence(idx + 1, s, sum, arr, n);
        return r + l;
    }

    public static void main(String[] args) {
        int[] arr = { 1, 2, 1 };
        int n = arr.length;
        int sum = 2;
        ArrayList<Integer> ds = new ArrayList<>();
        printS(0, ds, 0, sum, arr, n);

        System.out.println(printSubSquence(0, 0, sum, arr, n));
    }
}
