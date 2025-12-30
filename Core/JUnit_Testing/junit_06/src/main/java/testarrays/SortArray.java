package testarrays;

import java.util.Arrays;

public class SortArray {
    public int[] sortArr(int arr[]) {
        Arrays.sort(arr);
        return arr;
    }

    // for performance check
    public int[] sortArr2(int arr[]) {
        for (int i = 0; i < 1000000; i++) {
            Arrays.sort(arr);
        }
        return arr;
    }
}
