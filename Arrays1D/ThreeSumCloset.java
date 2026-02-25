import java.util.Arrays;

public class ThreeSumCloset {
    // 2 pointers apprach 
    public int threeSumClosest(int[] nums, int target) {
        Arrays.sort(nums);

        int closestSum = nums[0] + nums[1] + nums[2];

        for (int i = 0; i < nums.length - 2; i++) {
            int left = i + 1;
            int right = nums.length - 1;

            while (left < right) {

                int currentSum = nums[i] + nums[left] + nums[right];

                if (Math.abs(currentSum - target) < Math.abs(closestSum - target))
                    closestSum = currentSum;

                if (currentSum < target)
                    left = left + 1; // need bigger

                else if (currentSum > target)
                    right = right - 1; // need smaller

                else
                    return currentSum; // exact
            }
        }
        return closestSum;
    }

    /*
     * Example 1:
     * Input: nums = [-1,2,1,-4], target = 1
     * Output: 2
     * Explanation: The sum that is closest to the target is 2. (-1 + 2 + 1 = 2).
     * 
     * Example 2:
     * Input: nums = [0,0,0], target = 1
     * Output: 0
     * Explanation: The sum that is closest to the target is 0. (0 + 0 + 0 = 0).
     */
}
