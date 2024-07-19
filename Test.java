import java.util.*;

public class Test {
    public static void linearSearch(int arr[], int key) {
        int n = arr.length;
        for (int i = 0; i < n; i++) {
            if (arr[i] == key) {
                System.out.println("Element found at index :" + i);
                return;
            }
        }
        System.out.println("Element not found");
    }

    public static void getLargest(int arr[]) {
        int max = Integer.MIN_VALUE; // -infinity
        for (int i = 0; i < arr.length; i++) {
            if (max < arr[i]) {
                max = arr[i];
            }
        }
        System.out.println("largest element in array is : " + max);
    }

    public static void getSmallest(int arr[]) {
        int min = Integer.MAX_VALUE; // +infinity
        for (int i = 0; i < arr.length; i++) {
            if (min > arr[i]) {
                min = arr[i];
            }
        }
        System.out.println("Smallest element in array is : " + min);
    }

    public static void binarySearch(int arr[], int key) {
        int si = 0;
        int ed = arr.length - 1;
        while (si <= ed) {
            int mid = (si + ed) / 2;
            if (arr[mid] == key) {
                System.out.println("Element is found at index : " + mid);
                return;
            } else if (arr[mid] > key) {
                ed = mid - 1;
            } else {
                si = mid + 1;
            }
        }
        System.out.println("Element not found");
    }

    public static void reverseArray(int arr[]) {
        int first = 0;
        int last = arr.length - 1;
        while (first < last) {
            // swap
            int temp = arr[last];
            arr[last] = arr[first];
            arr[first] = temp;
            first++;
            last--;
        }
        System.out.println("Reverse of array:");
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + " ");
        }
        System.out.println();
    }

    public static void printPairs(int Num[]) {
        int totalPairs = 0;
        for (int i = 0; i < Num.length; i++) {
            int current = Num[i];
            for (int j = i + 1; j < Num.length; j++) {
                System.out.print("(" + current + "," + Num[j] + ")");
                totalPairs++;
            }
            System.out.println();
        }
        System.out.println("Total pairs are : " + totalPairs);
    }

    public static void printSubarray(int arr[]) {
        for (int i = 0; i < arr.length; i++) {
            int start = i;
            for (int j = i; j < arr.length; j++) {
                int end = j;
                for (int k = start; k <= end; k++) {
                    System.out.print(arr[k] + " ");
                }
                System.out.println();
            }
            System.out.println();
        }
    }

    public static void SubarraySum(int arr[]) {
        for (int i = 0; i < arr.length; i++) {
            int start = i;
            for (int j = i; j < arr.length; j++) {
                int end = j;
                int sum = 0;
                for (int k = start; k <= end; k++) {
                    sum = sum + arr[k];
                }
                System.out.print("Sum = " + sum);
                System.out.println();
            }
            System.out.println();
        }
    }

    public static void maxSubarraySum(int arr[]) {
        int maxSum = Integer.MIN_VALUE;
        for (int i = 0; i < arr.length; i++) {
            int start = i;
            for (int j = i; j < arr.length; j++) {
                int end = j;
                int sum = 0;
                for (int k = start; k <= end; k++) {
                    sum = sum + arr[k];
                }
                if (maxSum < sum) {
                    maxSum = sum;
                }
            }
        }
        System.out.println("Max subarray sum  is = " + maxSum);
    }

    public static void minSubarraySum(int arr[]) {
        int minSum = Integer.MAX_VALUE;
        for (int i = 0; i < arr.length; i++) {
            int start = i;
            for (int j = i; j < arr.length; j++) {
                int end = j;
                int sum = 0;
                for (int k = start; k <= end; k++) {
                    sum = sum + arr[k];
                }
                if (minSum > sum) {
                    minSum = sum;
                }
            }
        }
        System.out.println("Min subarray sum  is = " + minSum);
    }

    // *** Brute force *** //
    public static void BruteForce(int arr[]) {
        int maxSum = Integer.MIN_VALUE;
        for (int i = 0; i < arr.length; i++) {
            int start = i;
            for (int j = i; j < arr.length; j++) {
                int end = j;
                int sum = 0;
                for (int k = start; k <= end; k++) {
                    sum = sum + arr[k];
                }
                if (maxSum < sum) {
                    maxSum = sum;
                }
            }
        }
        System.out.println("Max subarray sum is = " + maxSum);
    }

    // *** Prefix Sum *** //
    public static void PrefixSum(int arr[]) {
        int maxSum = Integer.MIN_VALUE;
        int sum = 0;

        // prifix array
        int prefix[] = new int[arr.length];

        // to calculate prefix sum
        prefix[0] = arr[0];

        for (int i = 1; i < prefix.length; i++) {
            prefix[i] = prefix[i - 1] + arr[i];
        }

        for (int i = 0; i < arr.length; i++) {
            int start = i;
            for (int j = i; j < arr.length; j++) {
                int end = j;
                sum = start == 0 ? prefix[end] : prefix[end] - prefix[start - 1];
                if (maxSum < sum) {
                    maxSum = sum;
                }
            }
        }
        System.out.println("Max subarray sum is = " + maxSum);
    }

    // *** Kadane's Algorithm *** //
    public static void KadanesAlgo(int arr[]) {
        // ms => maxSum
        // cs => currentSum
        int ms = Integer.MIN_VALUE; // - infinity
        int cs = 0;
        for(int i = 0; i < arr.length; i++) {
            cs = cs + arr[i];
            if(cs < 0) {
                cs = 0;
            }
            ms = Math.max(cs, ms);
        }
        System.out.println("Max subarray sum is = " + ms);
    }

    // **Special Case for Kadane's Algorithim if all arr elements are negative** // 
    public static void KadanesAlgo2(int arr[]) {
        // ms => maxSum
        // cs => currentSum
        int ms = Integer.MIN_VALUE; // - infinity
        int cs = 0;
        int MinValue = Integer.MIN_VALUE;
        for(int i = 0; i < arr.length; i++) {
            cs = cs + arr[i];
            if(cs < 0) {
                cs = 0;
            }
            ms = Math.max(cs, ms);
            if(MinValue < arr[i]) {
                MinValue = arr[i];
            }
        }
        if (cs == 0) {
            System.out.println("Max subarray sum is = " + MinValue);
        } else {
            System.out.println("Max subarray sum is = " + ms);
        }
    }

    // ** Trapped Rainwater problem** //
    public static int trappedWater(int height[]) {
        int n = height.length;

        // calculate left max boundary 
            // LeftMax = Math.max(height[i], leftMax[i-1]);
        int leftMax[] = new int[n];
        leftMax[0] = height[0];
        for(int i=1; i<n; i++) {
            leftMax[i] = Math.max(height[i], leftMax[i-1]);
        }

        // calculate right max boundary 
            // RightMax = Math.max(height[i], leftMax[i+1]);
        int RightMax[] = new int[n];
        RightMax[n-1] = height[n-1];
        for(int i=n-2; i>=0; i--) {
            RightMax[i] = Math.max(height[i], RightMax[i+1]);
        }

        // Loop
        int trappedWater = 0;
        for(int i=0; i<n; i++) {
            // WaterLevel = min(leftMax, RightMax)
            int WaterLevel = Math.min(leftMax[i] , RightMax[i]);

            // TrappedWater += waterLevel - height[i]
            trappedWater += WaterLevel - height[i];
        }
        return trappedWater;
    }
    
    public static int buyAndSellStock(int prices[]) {
        int buyPrice = Integer.MAX_VALUE; 
        int maxProfit = 0;

        for(int i=0; i<prices.length; i++) {
            if( buyPrice < prices[i]) { // Profit
                int profit = prices[i] - buyPrice;  //todays profit
                maxProfit = Math.max(maxProfit, profit);
            } else {
                // if profit is less then buy them
                buyPrice = prices[i];
            }
        }
        return maxProfit;
    }
    
    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        // System.out.println("Enter the size of array :");
        // int n = sc.nextInt();
        // int arr[] = new int[n];
        // for (int i = 0; i < arr.length; i++) {
        //     System.out.print("Enter the Array elements at index " + i + ": ");
        //     arr[i] = sc.nextInt();
        // }
        // System.out.println("Enter the number to search :");
        // int key = sc.nextInt();

        // // linear search
        // linearSearch(arr, key);

        // // to find largest
        // getLargest(arr);

        // // to find Smallest
        // getSmallest(arr);

        // // Binary search
        // binarySearch(arr, key);

        // // Reverse an array
        // reverseArray(arr);

        // // Print pairs of an array
        // printPairs(arr);

        // // print sub array
        // printSubarray(arr);

        // // print subarray Sum
        // SubarraySum(arr);
        // sc.close();

        // // print max subarray sum
        // maxSubarraySum(arr);

        // // print min subarray sum
        // minSubarraySum(arr);

        // // Brute force
        // BruteForce(arr);

        // // Prefix sum
        // PrefixSum(arr);

        // // // Kadane's Algorithm
        // KadanesAlgo(arr);

        // // special case for if all array elements are negative
        // KadanesAlgo2(arr);

        int height[] = {4,2,0,6,3,2,5};
        int TotalTrappedWater = trappedWater(height);
        System.out.println("Total trapped water is : " + TotalTrappedWater);

        sc.close();
    }
}
