import java.util.Arrays;

public class MaxProdSubsequenceofK {

    public static int maxProduct(int[] arr, int k) {

        int n = arr.length;
        Arrays.sort(arr);

        // If k equals the array length, we must take all elements
        if (k == n) {
            long prod = 1;
            for (int x : arr)
                prod *= x;
            return (int) prod;
        }

        // If all elements are negative and k is odd, the result will be negative.
        // To maximize a negative product, we need the smallest absolute values
        // (i.e., the largest numbers at the end of the sorted array).
        if (arr[n - 1] <= 0 && k % 2 != 0) {
            long prod = 1;
            for (int i = n - 1; i >= n - k; i--) {
                prod *= arr[i];
            }
            return (int) prod;
        }

        // Otherwise, we can achieve a positive (or zero) product.
        // We use two pointers to compare pairs from the left (negatives) and right
        // (positives).
        int left = 0;
        int right = n - 1;
        long maxProd = 1;

        // If k is odd, we must pick at least one positive number to keep the product
        // positive.
        // The safest choice is the largest positive number available.
        if (k % 2 != 0) {
            maxProd *= arr[right];
            right--;
            k--;
        }

        // Now k is even. Compare pairs of negatives vs pairs of positives.
        while (k > 0) {
            long leftPair = (long) arr[left] * arr[left + 1];
            long rightPair = (long) arr[right] * arr[right - 1];
            if (leftPair > rightPair) {
                maxProd *= leftPair;
                left += 2;
            } else {
                maxProd *= rightPair;
                right -= 2;
            }
            k -= 2;
        }
        return (int) maxProd;
    }

    public static void main(String[] args) {
        /*
         * Max Product Subsequence of Size K
         * Given an array arr[] of integers and an integer k, find a subsequence of size
         * k whose product is maximum among all possible subsequences of size k. Return
         * the maximum product that can be obtained.
         * 
         * Examples:
         * Input: arr[] = [1, 2, 0, 3], k = 2
         * Output: 6
         * Explanation: Subsequence containing elements {2, 3} gives maximum product:
         * 2*3 = 6
         * 
         * Input: arr[] = [1, 2, -1, -3, -6, 4], k = 4
         * Output: 144
         * Explanation: Subsequence containing {2, -3, -6, 4} gives maximum product:
         * 2*(-3)*(-6)*4 = 144
         */
        int arr[] = { 1, 2, -1, -3, -6, 4 };
        int k = 4;
        int ans = maxProduct(arr, k);
        System.out.println(ans);
        int arr2[] = { -10, -8, -3, 2, 4, 7, 9 };
        int k2 = 3;
        int ans2 = maxProduct(arr2, k2);
        System.out.println(ans2);
        /*
         * 1 element (9) + 1 pair (-10, -8)
         * Possible choices include:
         * 9 × (-10) × (-8) = 720
         */

    }
}
