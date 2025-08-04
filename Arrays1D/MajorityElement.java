package Arrays1D;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

public class MajorityElement {

    // majority element n/2 times
    // T.c = O(N)
    public static int majorityElement(int[] nums) {
        HashMap<Integer, Integer> map = new HashMap<>();
        int n = nums.length;
        int maxElement = nums[0];

        for (int num : nums) {
            map.put(num, map.getOrDefault(num, 0) + 1);
            if (map.get(num) > n / 2) {
                maxElement = num;
            }
        }

        return maxElement;
    }

    public static int majorityElementCount(int[] nums) {
        HashMap<Integer, Integer> map = new HashMap<>();
        int n = nums.length;
        int maxCount = 0;

        for (int num : nums) {
            map.put(num, map.getOrDefault(num, 0) + 1);
            if (map.get(num) > n / 2) {
                maxCount = map.get(num);
            }
        }

        return maxCount;
    }

    // optimal
    public static int majorityElement2(int nums[]) {
        int n = nums.length;
        int count = 0;
        int el = 0;
        for (int i = 0; i < n; i++) {
            if (count == 0) {
                count = 1;
                el = nums[i];
            } else if (nums[i] == el)
                count++;
            else
                count--;
        }
        int count1 = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == el)
                count1++;
        }
        if (count1 > n / 2)
            return el;

        return -1;
    }

    // majority element n/3 times
    public static List<Integer> majorityElement4(int[] nums) {
        List<Integer> result = new ArrayList<>();
        HashMap<Integer, Integer> map = new HashMap<>();
        int n = nums.length;
        int mm = (int) (n / 3) + 1;

        for (int i = 0; i < n; i++) {
            map.put(nums[i], map.getOrDefault(nums[i], 0) + 1);
            if (map.get(nums[i]) == mm) {
                result.add(nums[i]);
            }
            // in a list there must be only 2 majority element in n/3 times
            if (result.size() == 2) {
                break;
            }
        }

        return result;
    }

    // optimal
    public static List<Integer> majorityElement5(int nums[]) {
        int n = nums.length;
        int count1 = 0;
        int count2 = 0;
        int el1 = 0;
        int el2 = 0;
        for (int i = 0; i < n; i++) {
            if (count1 == 0 && nums[i] != el2) {
                count1 = 1;
                el1 = nums[i];
            } else if (count2 == 0 && nums[i] != el1) {
                count2 = 1;
                el2 = nums[i];
            } else if (nums[i] == el1) {
                count1++;
            } else if (nums[i] == el2) {
                count2++;
            } else {
                count1--;
                count2--;
            }
        }

        // manual check
        count1 = 0;
        count2 = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == el1)
                count1++;
            if (nums[i] == el2)
                count2++;
        }

        List<Integer> result = new ArrayList<>();
        if (count1 > n/3) result.add(el1);
        if (count2 > n/3) result.add(el2);

        return result;
    }

    public static void main(String[] args) {
        int arr[] = { 2, 2, 1, 1, 1, 2, 2 };
        System.out.println(majorityElement(arr));
        System.out.println(majorityElementCount(arr));
        System.out.println(majorityElement2(arr));

        int[] nums1 = { 3, 2, 3 };
        System.out.println("Majority Element n/2 times");
        System.out.println("Input: " + Arrays.toString(nums1));
        System.out.println("Output: " + majorityElement2(nums1));

        System.out.println("Majority Element n/3  times");
        System.out.println("Output: " + majorityElement4(arr));
        System.out.println("Output: " + majorityElement4(nums1));
        System.out.println(majorityElement5(arr));
    }
}
