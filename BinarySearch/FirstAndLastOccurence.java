public class FirstAndLastOccurence {
    public int[] searchRange(int[] nums, int target) {
        int ans[] = new int[2];
        ans[0] = binarySearch(nums, target, true);
        ans[1] = binarySearch(nums, target, false);
        return ans;
    }

    public int binarySearch(int nums[], int target, boolean isSearchLeft) {
        int idx = -1;
        int st = 0;
        int ed = nums.length - 1;
        while (st <= ed) {
            int mid = st + (ed - st) / 2;
            if (nums[mid] > target) {
                ed = mid - 1;
            } else if (nums[mid] < target) {
                st = mid + 1;
            } else {
                // if nums[mid] == target
                idx = mid;
                // search in left for first occurence
                if (isSearchLeft) {
                    ed = mid - 1;
                } else {
                    // search in right for last occurence
                    st = mid + 1;
                }
            }
        }
        return idx;
    }

    public static void main(String[] args) {
        /*
         * Given an array of integers nums sorted in non-decreasing order, find the
         * starting and ending position of a given target value.
         * 
         * If target is not found in the array, return [-1, -1].
         * 
         * You must write an algorithm with O(log n) runtime complexity.
         * 
         * 
         * 
         * Example 1:
         * Input: nums = [5,7,7,8,8,10], target = 8
         * Output: [3,4]
         * 
         * Example 2:
         * Input: nums = [5,7,7,8,8,10], target = 6
         * Output: [-1,-1]
         * 
         * Example 3:
         * Input: nums = [], target = 0
         * Output: [-1,-1]
         */
    }
}
