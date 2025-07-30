package Arrays1D;

import java.util.HashMap;

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
            } 
            else if (nums[i] == el) count++;
            else count--;
        }
        int count1 = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == el) count1++;
        }
        if (count1 > n / 2) return el;
        
        return -1;
    }

    public static void main(String[] args) {
        int arr[] = { 2, 2, 1, 1, 1, 2, 2 };
        System.out.println(majorityElement(arr));
        System.out.println(majorityElementCount(arr));
        System.out.println(majorityElement2(arr));

    }
}
