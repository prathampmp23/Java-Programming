package Arrays1D;

public class KadanesAlgo {

    // Kadane's Algorithm
    public static void kadanesAlgo(int arr[]) {
        int currSum = 0;
        int maxSum = Integer.MIN_VALUE;

        for (int i = 0; i < arr.length; i++) {
            currSum += arr[i];
            if (maxSum < currSum) {
                maxSum = currSum;
            }
            if (currSum < 0) {
                currSum = 0;
            }
        }
        System.out.println("Maximum sum of kadane's subarray is: " + maxSum);
    }

    public static void kadanesAlgo2(int arr[]) {
        int currSum = 0;
        int maxSum = Integer.MIN_VALUE;
        int minValue = Integer.MIN_VALUE;

        for (int i = 0; i < arr.length; i++) {
            currSum += arr[i];
            if (currSum < 0) { // if currSum is negative make it 0
                currSum = 0;
            }
            maxSum = Math.max(maxSum, currSum);
            if (minValue < arr[i]) {
                minValue = arr[i];
            }
        }
        // special case if all values are negative then return smallest -ve value
        if (currSum == 0) {
            System.out.println("Maximum sum of kadane's subarray is: " + minValue);
        } else {
            System.out.println("Maximum sum of kadane's subarray is: " + maxSum);
        }
    }

    public static void main(String[] args) {
        // All negative values
        // int num[] = { -1, -2, -6, -1, -3 };
        int num[] = { -2, -3, 4, -1, -2, 1, 5, -3 };

        // Kadane's Algorithm
        System.out.println("Kadane's sum is  :");
        kadanesAlgo(num);
        kadanesAlgo2(num);
    }
}
