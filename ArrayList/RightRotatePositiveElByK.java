import java.util.*;

public class RightRotatePositiveElByK {

    public int[] rotateElements(int[] nums, int k) {

        List<Integer> pos = new ArrayList<>();
        for (int num : nums) {
            if (num > 0) {
                pos.add(num);
            }
        }

        // if no positive
        if (pos.size() == 0)
            return nums;

        int m = pos.size();
        k = k % m;

        reverse(pos, 0, k - 1); // left half till k
        reverse(pos, k, m - 1); // right half from k
        reverse(pos, 0, m - 1); // full list

        // Step 3: Put rotated positives back
        int idx = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] > 0) {
                nums[i] = pos.get(idx++);
            }
        }

        return nums;
    }

    // Reverse
    private void reverse(List<Integer> list, int left, int right) {
        while (left < right) {
            int temp = list.get(left);
            list.set(left, list.get(right));
            list.set(right, temp);

            left++;
            right--;
        }
    }

    public int[] rotateElements2(int[] nums, int k) {
        List<Integer> pos = new ArrayList<>();
        for (int num : nums) {
            if (num >= 0)
                pos.add(num);
        }

        if (pos.size() == 0)
            return nums;
        k = k % pos.size();

        // using collection
        // Left rotation by k = Right rotation by (size - k)
        Collections.rotate(pos, pos.size() - k);

        int idx = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] >= 0) {
                nums[i] = pos.get(idx++);
            }
        }
        return nums;
    }

    public static void main(String[] args) {
        /*
         * Input: nums = [5,4,-9,6], k = 2
         * Output: [6,5,-9,4]
         * 
         * Explanation:
         * The non-negative elements, in order, are [5, 4, 6].
         * Left rotation with k = 2 results in [6, 5, 4].
         * Placing them back into the non-negative indices results in [6, 5, -9, 4].
         */
    }

}
