package Arrays1D;

public class ReversePair {
    // Brute - O(N)
    public static int reversePairs(int[] nums) {
        int countNoPair = 0;
        int n = nums.length;
        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                if (nums[i] > 2 * nums[j])
                    countNoPair++;
            }
        }
        return countNoPair;
    }

    // optimal
    public static int reversePairs2(int[] nums) {
        int n = nums.length;
        return mergeSort(nums, 0, n - 1);
    }

    public static int mergeSort(int arr[], int low, int high) {
        int count = 0;
        if (low >= high) {
            return count;
        }
        int mid = low + (high - low) / 2;
        count += mergeSort(arr, low, mid);
        count += mergeSort(arr, mid + 1, high);
        count += countPair(arr, low, mid, high); // count pairs before merge
        merge(arr, low, mid, high);

        return count;
    }

    public static int countPair(int arr[], int low, int mid, int high) {
        int count = 0;
        int right = mid + 1;
        for (int i = low; i <= mid; i++) {
            while (right <= high && (long) arr[i] > 2L * (long) arr[right]) {
                right++;
            }
            count += (right - (mid + 1));
        }
        return count;
    }

    public static void merge(int arr[], int low, int mid, int high) {
        int temp[] = new int[high - low + 1];
        int i = low; // iteration for left part
        int j = mid + 1; // iteration for right part
        int k = 0; // iteration for temp[] arr

        while (i <= mid && j <= high) {
            if (arr[i] < arr[j]) {
                temp[k] = arr[i];
                i++;
            } else {
                temp[k] = arr[j];
                j++;
            }
            k++;
        }
        // Left part
        while (i <= mid) {
            temp[k++] = arr[i++];
        }
        // Right part
        while (j <= high) {
            temp[k++] = arr[j++];
        }
        // copy temp array to original arr
        for (k = 0, i = low; k < temp.length; k++, i++) {
            arr[i] = temp[k];
        }
    }

    public static void main(String[] args) {
        int arr[] = { 1, 3, 2, 3, 1 };
        System.out.println(reversePairs(arr));
        System.out.println(reversePairs2(arr));
    }
}
