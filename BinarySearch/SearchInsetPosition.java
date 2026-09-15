public class SearchInsetPosition {
    public int searchInsert(int[] nums, int target) {
        int st = 0;
        int ed = nums.length - 1;
        while (st <= ed) {
            int mid = st + (ed - st) / 2;
            if (nums[mid] == target)
                return mid;
            else if (nums[mid] > target)
                ed = mid - 1;
            else
                st = mid + 1;
        }
        return st;
    }

    public static void main(String[] args) {
        /*
         * Given a sorted array of distinct integers and a target value, return the
         * index if the target is found. If not, return the index where it would be if
         * it were inserted in order.
         * 
         * You must write an algorithm with O(log n) runtime complexity.
         * 
         * 
         * Example 1:
         * Input: nums = [1,3,5,6], target = 5
         * Output: 2
         * 
         * Example 2:
         * Input: nums = [1,3,5,6], target = 2
         * Output: 1
         * 
         * Example 3:
         * Input: nums = [1,3,5,6], target = 7
         * Output: 4
         */
    }
}
