package Arrays1D;

public class PrefixSum {
    // Prefix sum
    public static void prefixSum(int array[]) {
        int sum = 0;
        int maxSum = Integer.MIN_VALUE;

        int prefix[] = new int[array.length];
        prefix[0] = array[0];
        for (int i = 1; i < prefix.length; i++) {
            prefix[i] = prefix[i - 1] + array[i];
        }
        for (int i = 0; i < array.length; i++) {
            int start = i;
            for (int j = i; j < array.length; j++) {
                int end = j;
                sum = start == 0 ? prefix[end] : prefix[end] - prefix[start - 1];
                // System.out.println(sum);
                if (sum > maxSum) {
                    maxSum = sum;
                }
            }
        }
        System.out.println("Maximum sum of prefix subarray is: " + maxSum);
    }

    public static void main(String[] args) {

        int num[] = { -2, -3, 4, -1, -2, 1, 5, -3 };

        // Prefix sum
        System.out.println("Prefix sum :");
        prefixSum(num);
    }
}
