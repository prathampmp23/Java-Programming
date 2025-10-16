package Backtracking;

import java.util.ArrayList;

public class PrintSubsequence {
    public static void printS(int ind, ArrayList<Integer> ds, int s, int sum, int[] arr, int n) {
        // Base condition
        if (ind == n) {
            if (s == sum) {
                for (int it : ds) {
                    System.out.print(it + " ");
                }
                System.out.println();
            }
            return;
        }

        // Pick the current element
        ds.add(arr[ind]);
        s += arr[ind];
        printS(ind + 1, ds, s, sum, arr, n);

        // Backtrack (undo the pick)
        s -= arr[ind];
        ds.remove(ds.size() - 1);

        // Not pick the current element
        printS(ind + 1, ds, s, sum, arr, n);
    }

    public static void main(String[] args) {
        int[] arr = { 1, 2, 1 };
        int n = arr.length;
        int sum = 2;
        ArrayList<Integer> ds = new ArrayList<>();
        printS(0, ds, 0, sum, arr, n);
    }
}
