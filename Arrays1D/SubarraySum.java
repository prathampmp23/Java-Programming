package Arrays1D;

public class SubarraySum {
    public static void subarray(int arr[]) {
        for (int i = 0; i < arr.length; i++) {
            int start = i;
            for (int j = i; j < arr.length; j++) {
                int End = j;
                for (int k = start; k <= End; k++) {
                    System.out.print(arr[k] + " ");
                }
                System.out.println();
            }
            System.out.println();
        }
    }

    // Brute force
    public static void subarrSum(int arr[]) {
        int sum = 0;
        int maxSum = Integer.MIN_VALUE;
        for (int i = 0; i < arr.length; i++) {
            int start = i;
            for (int j = i; j < arr.length; j++) {
                int End = j;
                sum = 0;
                for (int k = start; k <= End; k++) {
                    // this calculates single subarray sum
                    sum += arr[k];
                }
                System.out.println(sum);
                if (maxSum < sum) {
                    maxSum = sum;
                }
            }
        }
        System.out.println("Maximum sum of subarray is: " + maxSum);
    }

    public static void main(String args[]) {
        int arr[] = { 2, 4, 6, 8, 10 };
        subarray(arr);
        subarrSum(arr);
    }
}
