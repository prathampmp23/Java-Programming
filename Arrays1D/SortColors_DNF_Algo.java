import java.util.Arrays;

public class SortColors_DNF_Algo {

    public static void sortColors(int[] nums) {
        // *** Dutch National flag Algorithm *** //
        int low = 0, mid = 0, high = nums.length - 1;
        while (mid <= high) {
            if (nums[mid] == 0) {
                // swap nums[low] & nums[mid]
                int temp = nums[low];
                nums[low] = nums[mid];
                nums[mid] = temp;
                low++;
                mid++;
            } else if (nums[mid] == 1) {
                // move mid pointer forward
                mid++;
            } else { // nums[mid] == 2
                // swap nums[mid] & nums[high]
                int temp = nums[mid];
                nums[mid] = nums[high];
                nums[high] = temp;
                high--;
            }
        }
    }

    public static void main(String[] args) {
        /*
         * Example 1:
         * Input: nums = [2,0,2,1,1,0]
         * Output: [0,0,1,1,2,2]
         * 
         * Explanation:
         * The array has two 0s, two 1s, and two 2s. Sorting them in-place places all 0s
         * first, then all 1s, then all 2s.
         * 
         * Example 2:
         * Input: nums = [2,0,1]
         * Output: [0,1,2]
         * 
         * Explanation:
         * The array has one each of 0, 1, and 2, arranged in-place in the order 0, 1,
         * 2.
         */
        int nums[] = { 2, 0, 2, 1, 1, 0 };
        sortColors(nums);
        Arrays.stream(nums).forEach(n -> System.out.print(n + " "));
    }
}
