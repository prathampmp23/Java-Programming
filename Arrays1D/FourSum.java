package Arrays1D;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class FourSum {

    // BruteForce
    public static List<List<Integer>> fourSum(int[] nums, int target) {
        List<List<Integer>> ans = new ArrayList<>();
        HashSet<List<Integer>> set = new HashSet<>();

        for (int i = 0; i < nums.length; i++) {
            for (int j = i + 1; j < nums.length; j++) {
                for (int k = j + 1; k < nums.length; k++) {
                    for (int l = k + 1; l < nums.length; l++) {
                        if (nums[i] + nums[j] + nums[k] + nums[l] == target) {
                            List<Integer> temp = new ArrayList<>();
                            temp.add(nums[i]);
                            temp.add(nums[j]);
                            temp.add(nums[k]);
                            temp.add(nums[l]);
                            Collections.sort(temp); // sorting
                            set.add(temp); // HashSet will remove duplicate quad
                        }
                    }
                }
            }
        }

        // Add unique quards to ans after loop
        ans.addAll(set);
        return ans;
    }

    // Better
    public static List<List<Integer>> fourSum2(int[] nums, int target) {
        List<List<Integer>> ans = new ArrayList<>();
        HashSet<List<Integer>> set = new HashSet<>(); // tp store unique quards

        for (int i = 0; i < nums.length; i++) {
            for (int j = i + 1; j < nums.length; j++) {
                Set<Integer> hs = new HashSet<>(); // lookup
                for (int k = j + 1; k < nums.length; k++) {
                    int l = target - (nums[i] + nums[j] + nums[k]);
                    if (hs.contains(l)) {
                        List<Integer> quard = Arrays.asList(nums[i], nums[j], nums[k], l);
                        Collections.sort(quard); // sort
                        set.add(quard); // add to set
                    }
                    hs.add(nums[k]);
                }
            }
        }
        // Add unique quad to ans after loop
        ans.addAll(set);
        return ans;
    }

    // optimal
    public static List<List<Integer>> fourSum3(int[] nums, int target) {
        Arrays.sort(nums);
        int n = nums.length;
        List<List<Integer>> ans = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            // skip duplicates for i
            if (i > 0 && nums[i] == nums[i - 1])
                continue;
            for (int j = i + 1; j < n; j++) {
                // skip duplicates for j
                if (j > i + 1 && nums[j] == nums[j - 1])
                    continue;
                int k = j + 1;
                int l = n - 1;
                while (k < l) {
                    long sum = (long) nums[i] + nums[j] + nums[k] + nums[l];
                    if (sum == target) {
                        ans.add(Arrays.asList(nums[i], nums[j], nums[k], nums[l]));
                        k++;
                        l--;
                        // skip duplicates for k
                        while (k < l && nums[k] == nums[k - 1])
                            k++;
                        // skip duplicates for l
                        while (k < l && nums[l] == nums[l + 1])
                            l--;

                    } else if (sum < target) {
                        k++;
                    } else {
                        l--;
                    }
                }
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        int nums[] = { 1, 0, -1, 0, -1, -2, 2 };
        int target = 0;
        // List<List<Integer>> result = fourSum(nums, target);
        List<List<Integer>> result = fourSum3(nums, target);
        System.out.println(result);

    }
}
