package Heaps;

public class HeapSort {

    // O(nlogn)
    public static void heapifyASC(int arr[], int idx, int size) {
        int left = 2 * idx + 1;
        int right = 2 * idx + 2;
        int maxIdx = idx;

        // leafchild < arrSize && parent < leftchild
        if (left < size && arr[maxIdx] < arr[left]) {
            maxIdx = left;
        }

        // leafchild < arrSize && parent < rightchild
        if (right < size && arr[maxIdx] < arr[right]) {
            maxIdx = right;
        }

        // if maxIdx value change then swap
        if (maxIdx != idx) {
            int temp = arr[idx];
            arr[idx] = arr[maxIdx];
            arr[maxIdx] = temp;

            // if due to this below child are disturb are fix
            heapifyASC(arr, maxIdx, size);
        }
    }

    public static void heapifyDESC(int arr[], int idx, int size) {
        int left = 2 * idx + 1;
        int right = 2 * idx + 2;
        int minIdx = idx;

        // leafchild < arrSize && parent > leftchild
        if (left < size && arr[minIdx] > arr[left]) {
            minIdx = left;
        }

        // leafchild < arrSize && parent > rightchild
        if (right < size && arr[minIdx] > arr[right]) {
            minIdx = right;
        }

        // if minIdx value change then swap
        if (minIdx != idx) {
            int temp = arr[idx];
            arr[idx] = arr[minIdx];
            arr[minIdx] = temp;

            // if due to this below child are disturb are fix
            heapifyDESC(arr, minIdx, size);
        }

    }

    public static void heapSort(int arr[]) {
        // step1 - build maxheap
        int n = arr.length;
        // last to upper level
        for (int i = n / 2; i >= 0; i--) {
            heapifyASC(arr, i, n);
        }

        // step2 - push largest at the end
        for (int i = n - 1; i >= 0; i--) {
            // swap
            int temp = arr[0];
            arr[0] = arr[i];
            arr[i] = temp;

            heapifyASC(arr, 0, i);
        }
    }

    public static void main(String[] args) {
        int arr[] = { 1, 2, 4, 5, 3 };
        heapSort(arr);

        // print
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + " ");
        }

    }
}
