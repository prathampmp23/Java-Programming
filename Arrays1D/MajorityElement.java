package Arrays1D;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class MajorityElement {

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

    public static List<Integer> majorityElement3(int[] nums) {
        List<Integer> result = new ArrayList<>();
        HashMap<Integer, Integer> map = new HashMap<>();
        int n = nums.length;

        for (int num : nums) {
            map.put(num, map.getOrDefault(num, 0) + 1);
        }

        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            if (entry.getValue() > n / 3) {
                result.add(entry.getKey());
            }
        }

        return result;
    }

    public static void main(String[] args) {
        int arr[] = { 2, 2, 1, 1, 1, 2, 2 };
        System.out.println(majorityElement(arr));
        System.out.println(majorityElementCount(arr));
        System.out.println(majorityElement2(arr));

        int[] nums1 = { 3, 2, 3 };
        System.out.println("Input: " + Arrays.toString(nums1));
        System.out.println("Output: " + majorityElement3(nums1));

    }
}
