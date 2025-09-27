package Arrays1D;

import java.util.Arrays;

public class ReturnDuplicates {

    public static void printDuplicates1(int arr[]) {
        Arrays.sort(arr);
        for (int i = 1; i < arr.length; i++) {
            if (arr[i - 1] == arr[i]) {
                System.out.println(arr[i]);
            }
        }
    }

    public static int[] printDuplicates2(int arr[]) {
        int ans[] = new int[arr.length];
        int idx = 0;
        for (int i = 0; i < arr.length; i++) {
            for (int j = i + 1; j < arr.length; j++) {
                if (arr[i] == arr[j]) {
                    ans[idx] = arr[i];
                    idx++;
                }
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        int arr[] = { 43, 323, 86, 323, 43, 396, 86 };
        printDuplicates1(arr);
        int ans[] = printDuplicates2(arr);
        for (int i = 0; i < ans.length; i++) {
            if (ans[i] != 0) {
                System.out.println(ans[i]);
            }
        }
    }
}
