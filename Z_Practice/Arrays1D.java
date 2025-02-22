package Z_Practice;

public class Arrays1D {

    // Linear Search
    public static int linearSearch(String arr[], String key) {
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == key) {
                return i;
            }
        }
        return -1;
    }

    // Binary Search
    public static int binarySearch(int arr[], int key) {
        int n = arr.length;
        int start = 0;
        int end = n - 1;
        while (start <= end) {
            int mid = (start + end) / 2;
            if (arr[mid] == key) {
                return mid;
            }
            if (arr[mid] > key) {
                // left part
                end = mid - 1;
            } else {
                // right part
                start = mid + 1;
            }
        }
        return -1;
    }

    // find largest
    public static int largest(int arr[]) {
        int largest = Integer.MIN_VALUE;
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] > largest) {
                largest = arr[i];
            }
        }
        return largest;
    }

    // find Smallest
    public static int smallest(int arr[]) {
        int smallest = Integer.MAX_VALUE;
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] < smallest) {
                smallest = arr[i];
            }
        }
        return smallest;
    }

    // Reverse array
    public static void reverseArray(int arr[]) {
        System.out.println("Original array");
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + " ");
        }
        System.out.println();

        int first = 0;
        int last = arr.length - 1;
        while (first < last) {
            // swaping
            int temp = arr[last];
            arr[last] = arr[first];
            arr[first] = temp;
            first++;
            last--;
        }

        System.out.println("Reverse array");
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + " ");
        }
        System.out.println();
    }

    // print arrays pairs
    public static void arrayPairs(int num[]) {
        int count = 0;
        for (int i = 0; i < num.length; i++) {
            int curr = num[i];
            for (int j = i + 1; j < num.length; j++) {
                System.out.print("(" + curr + "," + num[j] + ") ");
            }
            count++;
            System.out.println();
        }
        System.out.println("total count of pair : " + count);
    }

    // Print SubArray
    public static void SubArray(int array[]) {
        for (int i = 0; i < array.length; i++) {
            int start = i;
            for (int j = i; j < array.length; j++) {
                int end = j;
                for (int k = start; k <= end; k++) {
                    System.out.print("|" + array[k] + "| ");
                }
                System.out.println();
            }
            System.out.println();
        }
    }

    // print subarray sum
    public static void SubArraySum(int array[]) {
        int sum = 0;
        int maxSum = Integer.MIN_VALUE;
        int minSum = Integer.MAX_VALUE;
        for (int i = 0; i < array.length; i++) {
            int start = i;
            for (int j = i; j < array.length; j++) {
                int end = j;
                for (int k = start; k <= end; k++) {
                    System.out.print(array[k] + " ");
                    sum += array[k];
                }
                System.out.println();
            }
            System.out.println("sum is : " + sum);
            if (sum > maxSum) {
                maxSum = sum;
            }
            if (sum < minSum) {
                minSum = sum;
            }
            System.out.println();
        }
        System.out.println("maxSum of subArray is : " + maxSum);
        System.out.println("minSum of subArray is : " + minSum);
    }

    // ***************** Subarray sum *****************
    // **Brute Force**
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

    // **Prefix sum**
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

    // **Kadane's Algorithm**
    public static void kadanesAlgo(int arr[]) {
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

    public static void kadanesAlgo2(int arr[]) {
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

    // Calculate Traped Water
    public static int trappedWater(int height[]) {
        // calculate left max boundary - (Auxilary array)
        int leftMax[] = new int[height.length];
        leftMax[0] = height[0];
        for (int i = 1; i < leftMax.length; i++) {
            leftMax[i] = Math.max(height[i], leftMax[i - 1]);
        }
        // calculate right max boundary - (Auxilary array)
        int rightMax[] = new int[height.length];
        rightMax[height.length - 1] = height[height.length - 1];
        for (int i = height.length - 2; i >= 0; i--) {
            rightMax[i] = Math.max(height[i], rightMax[i + 1]);
        }
        // Loop
        int trapedWater = 0;
        for (int i = 0; i < height.length; i++) {
            // waterlevel = min(leftmax, rightMax)
            int waterLevel = Math.min(leftMax[i], rightMax[i]);
            // trapedWater = waterLevel - height[i]
            trapedWater += waterLevel - height[i];
        }
        return trapedWater;
    }

    public static int trappedWater2(int[] height) {
        int n = height.length;
    
        int totalWater = 0;
        int left = 0, right = n - 1;
        int rightMax = height[right], leftMax = height[left];
    
        while (left < right) {
            if (leftMax < rightMax) {
                left++;
                leftMax = Math.max(leftMax, height[left]);
                totalWater += leftMax - height[left];
            } else {
                right--;
                rightMax = Math.max(rightMax, height[right]);
                totalWater += rightMax - height[right];
            }
        }
        
        return totalWater;
    }

    // Buy and Sell Stock
    public static int buyAndSellStock(int salePrice[]) {
        int buyPrice = Integer.MAX_VALUE;
        int maxProfit = 0;
        for (int i = 0; i < salePrice.length; i++) {
            if (buyPrice < salePrice[i]) { // Profit
                int profit = salePrice[i] - buyPrice; // Todays profit
                maxProfit = Math.max(maxProfit, profit);
            } else {
                // If price is less than buy price then time to buy
                buyPrice = salePrice[i];
            }
        }
        return maxProfit;
    }

    // Check is number Distinct or not
    public static boolean isDistinct(int arr[]) {
        for (int i = 0; i < arr.length; i++) {
            for (int j = i + 1; j < arr.length; j++) {
                if (arr[i] == arr[j]) {
                    return true;
                }
            }
        }
        return false;
    }

    // ***************** Sorting *****************

    // Bubble Sorting
    public static void bubbleSort(int arr[]) {
        for (int turn = 0; turn < arr.length - 1; turn++) {
            for (int j = 0; j < arr.length - 1 - turn; j++) {
                if (arr[j] > arr[j + 1]) {
                    int temp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = temp;
                }
            }
        }
    }

    // Selection Sorting
    public static void selectionSort(int arr[]) {
        for (int i = 0; i < arr.length - 1; i++) {
            int minPosition = i;
            for (int j = i + 1; j < arr.length; j++) {
                if (arr[j] < arr[minPosition]) {
                    minPosition = j;
                }
            }
            int temp = arr[i];
            arr[i] = arr[minPosition];
            arr[minPosition] = temp;
        }
    }

    // Insertion Sorting
    public static void insertionSort(int arr[]) {
        for (int i = 1; i < arr.length; i++) {
            int current = arr[i];
            int previous = i - 1;
            // finding correct position to insert
            while (previous >= 0 && arr[previous] > current) {
                arr[previous + 1] = arr[previous];
                previous--;
            }
            // insert current element
            arr[previous + 1] = current;
        }
    }

    // Count Sorting
    public static void countingSort(int arr[]) {
        int largest = Integer.MIN_VALUE;
        for (int i = 0; i < arr.length; i++) {
            largest = Math.max(largest, arr[i]);
        }
        // to calculate frequency
        int count[] = new int[largest + 1];
        for (int i = 0; i < arr.length; i++) {
            count[arr[i]]++;
        }
        // Sorting
        int j = 0;
        for (int i = 0; i < count.length; i++) {
            while (count[i] > 0) {
                arr[j] = i;
                j++;
                count[i]--;
            }
        }
    }

    public static void main(String[] args) {
        String strArr[] = { "samosa", "poha", "idli", "kauchori", "sambarvada", "upma" };
        String key = "idli";
        System.out.println("String is found at index : " + linearSearch(strArr, key));

        int arr[] = { 1, 2, 3, 4, 5 };
        System.out.println("largest is : " + largest(arr));
        System.out.println("smallest is : " + smallest(arr));

        int array[] = { 1, 2, 3, 4, 5, 6, 7, 8, 9, 10 };
        System.out.println("Element is found at index : " + binarySearch(array, 11));

        reverseArray(array);

        System.out.println("Pairs of array :");
        arrayPairs(array);

        System.out.println("SubArray :");
        SubArray(arr);

        System.out.println("SubArraySum :");
        SubArraySum(arr);

        int num[] = { -1, -2, -6, -1, -3 };
        // int number[] = { -2, -3, 4, -1, -2, 1, 5, -3 };

        // Brute Force
        System.out.println("MaxSubArraySum :");
        maxSubArraySum(num);

        // Prefix sum
        System.out.println("Prefix sum :");
        prefixSum(num);

        // Kadane's Algorithm
        System.out.println("Kadane's sum is  :");
        kadanesAlgo2(num);

        // Trapped water
        int height[] = { 4, 2, 0, 6, 3, 2, 5 };
        int TotalTrappedWater = trappedWater(height);
        System.out.println("Total trapped water is : " + TotalTrappedWater);

        // Buy and sell stock
        int price[] = { 7, 1, 5, 3, 6, 4 };
        int TotalProfit = buyAndSellStock(price);
        System.out.println("Total profit is : " + TotalProfit);

        // Check Distinct
        int nums[] = { 1, 2, 3, 1 };
        System.out.println("Is distinct : " + isDistinct(nums));

        // Sorting
        int arr1[] = { 5, 4, 3, 2, 1 };
        countingSort(arr1);
        for (int i = 0; i < arr1.length; i++) {
            System.out.print(arr1[i] + " ");
        }

        
    }
}
