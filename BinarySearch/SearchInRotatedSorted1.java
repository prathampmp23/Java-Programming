public class SearchInRotatedSorted1 {
    public int search(int[] nums, int target) {
        int st = 0;
        int ed = nums.length - 1;
        while (st <= ed) {
            int mid = st + (ed - st) / 2;

            // if target found
            if (nums[mid] == target) {
                return mid;
            }

            // if left half is sorted
            else if (nums[st] <= nums[mid]) {
                if (nums[st] <= target && target <= nums[mid])
                    ed = mid - 1; // move to right part
                else
                    st = mid + 1; // move to left part
            }

            // if right half is sorted
            else {
                if (nums[mid] <= target && target <= nums[ed])
                    st = mid + 1; // move to left part
                else
                    ed = mid - 1; // move to right part
            }
        }

        // no target is found
        return -1;
    }

    public static void main(String[] args) {
        /*
         * There is an integer array nums sorted in ascending order (with distinct
         * values).
         * 
         * Prior to being passed to your function, nums is possibly left rotated at an
         * unknown index k (1 <= k < nums.length) such that the resulting array is
         * [nums[k], nums[k+1], ..., nums[n-1], nums[0], nums[1], ..., nums[k-1]]
         * (0-indexed). For example, [0,1,2,4,5,6,7] might be left rotated by 3 indices
         * and become [4,5,6,7,0,1,2].
         * 
         * Given the array nums after the possible rotation and an integer target,
         * return the index of target if it is in nums, or -1 if it is not in nums.
         * 
         * You must write an algorithm with O(log n) runtime complexity.
         * 
         * 
         * 
         * Example 1:
         * Input: nums = [4,5,6,7,0,1,2], target = 0
         * Output: 4
         * 
         * Example 2:
         * Input: nums = [4,5,6,7,0,1,2], target = 3
         * Output: -1
         * 
         * Example 3:
         * Input: nums = [1], target = 0
         * Output: -1
         * 
         * Constraints:
         * 1 <= nums.length <= 5000
         * -104 <= nums[i] <= 104
         * All values of nums are unique.
         * nums is an ascending array that is possibly rotated.
         * -104 <= target <= 104
         */
    }
}
