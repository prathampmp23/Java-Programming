package Heaps;

public class HeapConverter {
    public int[] convertMinToMax(int[] nums) {
        if (nums == null)
            return null;
        int n = nums.length;
        // last non-leaf index = n/2 - 1
        for (int i = n / 2 - 1; i >= 0; i--) {
            siftDown(nums, i, n);
        }
        return nums;
    }

    private void siftDown(int[] arr, int i, int n) {
        while (true) {
            int left = 2 * i + 1;
            int right = 2 * i + 2;
            int largest = i;

            if (left < n && arr[left] > arr[largest])
                largest = left;
            if (right < n && arr[right] > arr[largest])
                largest = right;

            // if no childrens found
            if (largest == i)
                break;
            swap(arr, i, largest);
            i = largest;
        }
    }

    private void swap(int[] arr, int i, int j) {
        int t = arr[i];
        arr[i] = arr[j];
        arr[j] = t;
    }
    
    private static void print(int[] a) {
        if (a == null) {
            System.out.println("null");
            return;
        }
        for (int x : a)
            System.out.print(x + " ");
        System.out.println();
    }

    public static void main(String[] args) {
        HeapConverter s = new HeapConverter();
        int[] a1 = { 10, 20, 30, 21, 23 };
        int[] res1 = s.convertMinToMax(a1);
        print(res1); // one valid output: [30, 21, 23, 10, 20]

        int[] a2 = { -5, -4, -3, -2, -1 };
        int[] res2 = s.convertMinToMax(a2);
        print(res2); // one valid output: [-1, -2, -3, -4, -5]
    }

}
