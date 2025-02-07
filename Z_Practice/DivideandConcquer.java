package Z_Practice;

public class DivideandConcquer {

    public static void mergeSort(int arr[], int si, int ei) {
        // Base case
        if (si >= ei) {
            return;
        }
        int mid = si + (ei - si) / 2; // or (si+ei)/2
        mergeSort(arr, si, mid); // Left part
        mergeSort(arr, mid + 1, ei); // Right part
        merge(arr, si, mid, ei); // calling merge() fun
    }

    public static void merge(int arr[], int si, int mid, int ei) {
        int temp[] = new int[ei - si + 1];
        int i = si; // iterator of left part
        int j = mid + 1; // iterator of right part
        int k = 0; // iterator for temp array
        while (i <= mid && j <= ei) {
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
        while (j <= ei) {
            temp[k++] = arr[j++];
        }
        // copy temp to original array
        for (k = 0, i = si; k < temp.length; k++, i++) {
            arr[i] = temp[k];
        }
    }

    public static void quickSort(int arr[], int si, int ei) {
        if (si >= ei) {
            return;
        }
        // pivot -> last element
        int pivotIdx = partition(arr, si, ei);
        quickSort(arr, si, pivotIdx - 1); // left
        quickSort(arr, pivotIdx + 1, ei); // Right
    }

    public static int partition(int arr[], int si, int ei) {
        int pivot = arr[ei];
        int i = si - 1; // to make place for element smaller than pivot
        for (int j = si; j < ei; j++) {
            if (arr[j] <= pivot) {
                i++; // make place
                // swap
                int temp = arr[j];
                arr[j] = arr[i];
                arr[i] = temp;
            }
        }
        i++;
        // swap
        int temp = pivot;
        arr[ei] = arr[i]; // x(wrong) pivot = arr[i]
        arr[i] = temp;
        return i;
    }

    public static int RotatedArraySearch(int arr[], int target, int si, int ei) {
        // Base case
        if (si > ei) {
            return -1;
        }
        int mid = si + (ei - si) / 2;
        // case found
        if (arr[mid] == target) {
            return mid;
        }
        // Mid on Line1
        if (arr[si] <= arr[mid]) {
            // case 1: left part
            if (arr[si] <= target && target <= arr[mid]) {
                return RotatedArraySearch(arr, target, si, mid - 1);
            } else {
                // case 2: right part
                return RotatedArraySearch(arr, target, mid + 1, ei);
            }
        }
        // Mid on Line1
        else {
            // case 3: Right part
            if (arr[mid] <= target && target <= arr[ei]) {
                return RotatedArraySearch(arr, target, mid + 1, ei);
            } else {
                // case 4: left part
                return RotatedArraySearch(arr, target, si, mid - 1);
            }
        }
    }

    public static void printArr(int arr[]) {
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + " ");
        }
        System.out.println();
    }

    public static void main(String[] args) {
        int arr[] = { 6, 3, 9, 5, 2, 8 };
        // mergeSort(arr, 0, arr.length - 1);
        quickSort(arr, 0, arr.length - 1);
        printArr(arr);
        int array[] = { 4, 5, 6, 7, 0, 1, 2 };
        int target = 0;
        System.out.println("Index = "+RotatedArraySearch(array, target, 0, array.length - 1));;
    }
}
