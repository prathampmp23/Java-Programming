package Arrays2D;

public class LeftRotateArrray {

    public static void leftRotateByOnePlace(int arr[]) {
        int n = arr.length;
        int temp = arr[0];
        for (int i = 1; i < n; i++) {
            arr[i - 1] = arr[i];
        }
        arr[n - 1] = temp;
    }

    public static void leftRotate(int arr[], int k) {
        int n = arr.length;
        k = k % n;
        int temp[] = new int[k];
        // store first element till k in temp
        for (int i = 0; i < temp.length; i++) {
            temp[i] = arr[i];
        }

        // move elements after k to start
        for (int i = k; i < n; i++) {
            arr[i - k] = arr[i];
        }

        // place the temp elements to last
        for (int i = n - k; i < n; i++) {
            arr[i] = temp[i - (n - k)];
        }
    }

    public static void leftRotate2(int nums[], int k) {
        int n = nums.length;
        k = k % n;

        int[] temp = new int[k];
        // Store last k elements
        for (int i = 0; i < k; i++) {
            temp[i] = nums[n - k + i];
        }

        // Shift the remaining elements to the right
        for (int i = n - 1 - k; i >= 0; i--) {
            nums[i + k] = nums[i];
        }

        // Place the stored k elements at the start
        for (int i = 0; i < k; i++) {
            nums[i] = temp[i];
        }
    }

    // using reverse optimized
    public static void reverse(int num[], int first, int last) {
        while (first < last) {
            int temp = num[last];
            num[last] = num[first];
            num[first] = temp;
            first++;
            last--;
        }
    }

    public static void leftRotateReverse(int nums[], int k) {
        int n = nums.length;
        k = k % n; // in case k > n

        // Step 1: Reverse the whole array
        reverse(nums, 0, n - 1);

        // Step 2: Reverse the first k elements
        reverse(nums, 0, k - 1);

        // Step 3: Reverse the remaining elements
        reverse(nums, k, n - 1);
    }

    public static void main(String[] args) {
        int arr1[] = { 1, 2, 3, 4, 5 };
        leftRotateByOnePlace(arr1);
        for (int i = 0; i < arr1.length; i++) {
            System.out.print(arr1[i] + " ");
        }

        System.out.println();

        int arr2[] = { -1, -100, 3, 99 };
        // leftRotate(arr2, 2);
        // // leftRotate2(arr2, 2);
        // for (int i = 0; i < arr2.length; i++) {
        // System.out.print(arr2[i] + " ");
        // }

        leftRotateReverse(arr2, 2);
        for (int i = 0; i < arr2.length; i++) {
            System.out.print(arr2[i] + " ");
        }
    }
}
