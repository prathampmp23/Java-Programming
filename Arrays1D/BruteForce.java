package Arrays1D;

public class BruteForce {
    // Brute Force
    public static void maxSubArraySum(int array[]) {
        int curr = 0;
        int maxSum = Integer.MIN_VALUE;
        for (int i = 0; i < array.length; i++) {
            int start = i;
            for (int j = i; j < array.length; j++) {
                int end = j;
                curr = 0;
                for (int k = start; k <= end; k++) {
                    curr += array[k];
                }
                // System.out.println(curr);
                if (curr > maxSum) {
                    maxSum = curr;
                }
            }
        }
        System.out.println("Maximum sum of subarray is: " + maxSum);
    }

    public static void main(String[] args) {
        int num[] = { -2, -3, 4, -1, -2, 1, 5, -3 };

        // Prefix sum
        System.out.println("Prefix sum :");
        maxSubArraySum(num);
    }
}
