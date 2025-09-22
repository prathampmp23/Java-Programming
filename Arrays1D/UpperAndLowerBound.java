package Arrays1D;

import java.util.Arrays;

public class UpperAndLowerBound {
    // using Binary Search
    public static int[] getUpperAndLower(int[] arr, int x) {
        Arrays.sort(arr);
        int lowerBound = getLowerBound(arr, x);
        int upperBound = getUpperBound(arr, x);
        return new int[] { lowerBound, upperBound };
    }

    static int getUpperBound(int[] arr, int x) {
        int low = 0, high = arr.length - 1, ans = -1;
        while (low <= high) {
            int mid = low + (high - low) / 2;
            if (arr[mid] > x) {
                ans = arr[mid];
               high = mid - 1; // move left to look for more smaller index 
            } else {
                low = mid + 1;
            }
        }
        return ans;
    }

    static int getLowerBound(int[] arr, int x) {
        int low = 0, high = arr.length - 1, ans = -1;
        while (low <= high) {
            int mid = low + (high - low) / 2;
            // it may be the ans
            if (arr[mid] >= x) {
                ans = arr[mid];
                high = mid - 1; // move left to look for more smaller index 
            } else {
                low = mid + 1;
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        int arr[] = { 5, 6, 8, 9, 6, 5, 5, 6 };
        int x = 8;
        int ans[] = getUpperAndLower(arr, x);
        System.out.println("Lower Bound = " + ans[0]);
        System.out.println("Upper Bound = " + ans[1]);
    }
}
