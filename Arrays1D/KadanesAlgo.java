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

    public static void kadanesAlgo3(int nums[]) {
        int ms = nums[0];
        int cs = nums[0];

        for (int i = 1; i < nums.length; i++) {
            cs = Math.max(nums[i], cs + nums[i]);
            ms = Math.max(ms, cs);
        }

        System.out.println("Maximum sum of kadane's subarray is: " + ms);
    }

    // to print maxSubarray element
    public static void kadanesAlgo4(int arr[]) {
        int currSum = 0;
        int maxSum = Integer.MIN_VALUE;
        int start = 0;
        int ansSt = 0;
        int ansEd = 0;

        for (int i = 0; i < arr.length; i++) {
            // if sum == 0 then we have new start
            if (currSum == 0) {
                start = i;
            }
            currSum += arr[i];

            if (maxSum < currSum) {
                maxSum = currSum;
                ansSt = start;
                ansEd = i;
            }
            if (currSum < 0) {
                currSum = 0;
            }
        }
        System.out.println("Max Subarray = ");
        for (int i = ansSt; i <= ansEd; i++) {
            System.out.print(arr[i] + " ");
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
        kadanesAlgo3(num);
        // print maxSubArray sum
        kadanesAlgo4(num);
    }
}
