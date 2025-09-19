package Arrays1D;

import java.util.Arrays;

public class UpperAndLowerBound {
    public static int[] getUpperAndLower(int[] arr, int x) {
        Arrays.sort(arr);
        int upperBound = getCeil(arr, x);
        int lowerBound = getFloor(arr, x);
        return new int[] { upperBound, lowerBound };
    }

    static int getFloor(int[] arr, int x) {
        int low = 0, high = arr.length - 1, ans = -1;
        while (low <= high) {
            int mid = low + (high - low) / 2;
            if (arr[mid] <= x) {
                ans = arr[mid];
                low = mid + 1; // move right
            } else {
                high = mid - 1;
            }
        }
        return ans;
    }

    // Ceil
    static int getCeil(int[] arr, int x) {
        int low = 0, high = arr.length - 1, ans = -1;
        while (low <= high) {
            int mid = low + (high - low) / 2;
            if (arr[mid] >= x) {
                ans = arr[mid];
                high = mid - 1; // move left
            } else {
                low = mid + 1;
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        int arr[] = { 5, 6, 8, 9, 6, 5, 5, 6 };
        int x = 7;
        int ans[] = getUpperAndLower(arr, x);
        System.out.println("Upper Bound = " + ans[0]);
        System.out.println("Lower Bound = " + ans[1]);
        System.out.println(getFloor(arr, x));
        System.out.println(getCeil(arr, x));
    }
}
