package Backtracking;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class PrintSubsetNum {
    public static List<List<Integer>> getAllSubsets(int[] arr) {
        // write your code here
        Arrays.sort(arr);
        List<List<Integer>> ans = new ArrayList<>();
        subset(arr, 0, ans, new ArrayList<>());
        return ans;
    }

    public static void subset(int nums[], int idx, List<List<Integer>> ans, List<Integer> curr) {
        if (idx == nums.length) {
            return;
        }
        // choose nums[i]
        curr.add(nums[idx]);
        // add current subset immediately (this creates the preorder-like listing)
        ans.add(new ArrayList<>(curr));
        subset(nums, idx + 1, ans, curr);

        // backtrack
        curr.remove(curr.size() - 1);
        subset(nums, idx + 1, ans, curr);
    }

    // method using loop
    public static List<List<Integer>> subsetsInSampleOrder(int[] nums) {
        List<List<Integer>> ans = new ArrayList<>();
        List<Integer> curr = new ArrayList<>();
        dfs(nums, 0, curr, ans);
        return ans;
    }

    private static void dfs(int[] nums, int idx, List<Integer> curr, List<List<Integer>> ans) {
        int n = nums.length;
        for (int i = idx; i < n; i++) {
            // choose nums[i]
            curr.add(nums[i]);
            // add current subset immediately (this creates the preorder-like listing)
            ans.add(new ArrayList<>(curr));

            // recurse to extend this subset
            dfs(nums, i + 1, curr, ans);

            // backtrack
            curr.remove(curr.size() - 1);
        }
    }

    public static void main(String[] args) {
        List<List<Integer>> list1 = getAllSubsets(new int[] { 1, 2, 3 });
        // System.out.println(list1);
        for (List<Integer> inner : list1) {
            System.out.println(inner);
        }
        for (List<Integer> inner : list1) {
            for (Integer x : inner) {
                System.out.print(x + " ");
            }
            System.out.println();
        }
        // List<List<Integer>> list2 = subsetsInSampleOrder(new int[] { 1, 2, 3 });
        // System.out.println(list2);
    }

}
