import java.util.ArrayDeque;
import java.util.Deque;

public class CountSubarraysWithSumK {

    public static long countSubarrays(int[] nums, long k) {

        int n = nums.length;

        // Deque to maintain decreasing order (front = maximum)
        Deque<Integer> maxDeque = new ArrayDeque<>();

        // Deque to maintain increasing order (front = minimum)
        Deque<Integer> minDeque = new ArrayDeque<>();

        int left = 0; // Left pointer of sliding window
        long answer = 0; // Total valid subarrays

        // Right pointer expands the window
        for (int right = 0; right < n; right++) {

            // --------------------------------------------------
            // 1. Maintain MAX deque (monotonically decreasing)
            // --------------------------------------------------
            // Remove all smaller elements from the back
            // because they can never be maximum again
            while (!maxDeque.isEmpty() && nums[maxDeque.peekLast()] <= nums[right]) {
                maxDeque.pollLast();
            }

            // Add current index
            maxDeque.offerLast(right);

            // --------------------------------------------------
            // 2. Maintain MIN deque (monotonically increasing)
            // --------------------------------------------------
            // Remove all larger elements from the back
            // because they can never be minimum again
            while (!minDeque.isEmpty() && nums[minDeque.peekLast()] >= nums[right]) {
                minDeque.pollLast();
            }

            // Add current index
            minDeque.offerLast(right);

            // --------------------------------------------------
            // 3. Shrink window while cost > k
            // --------------------------------------------------
            while (!maxDeque.isEmpty() && !minDeque.isEmpty() &&
                    (long) (nums[maxDeque.peekFirst()] - nums[minDeque.peekFirst()]) * (right - left + 1) > k) {

                // If left element is current max, remove it
                if (maxDeque.peekFirst() == left) {
                    maxDeque.pollFirst();
                }

                // If left element is current min, remove it
                if (minDeque.peekFirst() == left) {
                    minDeque.pollFirst();
                }

                // Move left pointer
                left++;
            }

            // --------------------------------------------------
            // 4. Count valid subarrays ending at 'right'
            // --------------------------------------------------
            // All subarrays:
            // [left...right], [left+1...right], ..., [right...right]
            answer += (right - left + 1);
        }

        return answer;
    }

    public static void main(String[] args) {
        /*
         * Input: nums = [1,3,2], k = 4
         * Output: 5
         * 
         * Explanation:
         * We consider all subarrays of nums:
         * nums[0..0]: cost = (1 - 1) * 1 = 0
         * nums[0..1]: cost = (3 - 1) * 2 = 4
         * nums[0..2]: cost = (3 - 1) * 3 = 6
         * nums[1..1]: cost = (3 - 3) * 1 = 0
         * nums[1..2]: cost = (3 - 2) * 2 = 2
         * nums[2..2]: cost = (2 - 2) * 1 = 0
         * There are 5 subarrays whose cost is less than or equal to 4.
         */
        int nums[] = { 1, 3, 2 };
        int k = 4;
        System.out.println(countSubarrays(nums, k));
    }
}
