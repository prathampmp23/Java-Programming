package Arrays1D;

public class NextPermutation {
    public static void nextPermutation(int arr[]) {
        int idx = -1;
        int n = arr.length;

        for (int i = n - 2; i >= 0; i--) {
            if (arr[i] < arr[i + 1]) {
                idx = i; // break idx
                break;
            }
        }

        // if no break point find reverse it as it may last permutation
        if (idx == -1) {
            reverse(arr, 0, n - 1);
            return;
        }

        for (int i = n - 1; i > idx; i--) {
            if (arr[i] > arr[idx]) {
                // swap
                int temp = arr[i];
                arr[i] = arr[idx];
                arr[idx] = temp;
                break;
            }
        }
        reverse(arr, idx + 1, n - 1);
    }

    public static void reverse(int num[], int first, int last) {
        while (first < last) {
            int temp = num[last];
            num[last] = num[first];
            num[first] = temp;
            first++;
            last--;
        }
    }

    public static void main(String[] args) {
        int arr[] = {1,2,3};
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + " ");
        } System.out.println();
        System.out.println("Next Permutation");
        nextPermutation(arr);
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + " ");
        }
    }
}
