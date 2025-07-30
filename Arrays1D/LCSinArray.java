package Arrays1D;

import java.util.Arrays;
import java.util.HashSet;

public class LCSinArray {

    // Better
    public static int lcs(int arr[]) {
        if (arr.length == 0) {
            return 0;
        }

        int n = arr.length;
        Arrays.sort(arr);
        int lastSamller = Integer.MIN_VALUE;
        int count = 0;
        int longest = 1;

        for (int i = 0; i < n; i++) {
            if (arr[i] - 1 == lastSamller) {
                count++;
                lastSamller = arr[i];
            } else if (arr[i] != lastSamller) {
                count = 1;
                lastSamller = arr[i];
            }
            longest = Math.max(longest, count);
        }
        return longest;
    }

    // optimal
    public static int lcs2(int nums[]) {
        if (nums.length == 0)
            return 0;

        HashSet<Integer> set = new HashSet<>();
        for (int num : nums) {
            set.add(num);
        }

        int longest = 0;

        for (int num : nums) {
            // Check if 'num' is the start of a sequence
            if (!set.contains(num - 1)) {
                int currentNum = num;
                int count = 1;

                while (set.contains(currentNum + 1)) {
                    currentNum++;
                    count++;
                }

                longest = Math.max(longest, count);
            }
        }

        return longest;
    }

    public static void main(String[] args) {
        int arr[] = { 100, 4, 200, 1, 3, 2 };
        System.out.println(lcs(arr));
        System.out.println(lcs2(arr));
    }
}
