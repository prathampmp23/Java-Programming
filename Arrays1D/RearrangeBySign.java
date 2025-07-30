package Arrays1D;

import java.util.ArrayList;
import java.util.List;

public class RearrangeBySign {

    // Brute force
    public static void rearrange(int arr[]) {
        int n = arr.length;
        int positive[] = new int[n / 2];
        int negative[] = new int[n / 2];

        int idx = 0;
        int idx1 = 0;
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] > 0) {
                positive[idx] = arr[i];
                idx++;
            } else {
                negative[idx1] = arr[i];
                idx1++;
            }
        }
        for (int i = 0; i < n / 2; i++) {
            arr[2 * i] = positive[i];
            arr[2 * i + 1] = negative[i];
        }
    }

    // optimal
    public static int[] rearrangeArray(int arr[]) {
        int ans[] = new int[arr.length];
        int postIdx = 0;
        int negtIdx = 1;
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] > 0) {
                ans[postIdx] = arr[i];
                postIdx += 2;
            } else {
                ans[negtIdx] = arr[i];
                negtIdx += 2;
            }
        }
        return ans;
    }

    // Brute force if -ve and +ve are not same in element
    public static void rearrange2(int arr[]) {
        List<Integer> positive = new ArrayList<>();
        List<Integer> negative = new ArrayList<>();

        for (int i = 0; i < arr.length; i++) {
            if (arr[i] > 0) {
                positive.add(arr[i]);
            } else {
                positive.add(arr[i]);
            }
        }

        if (positive.size() > negative.size()) {
            for (int i = 0; i < negative.size(); i++) {
                arr[2 * i] = positive.get(i);
                arr[2 * i + 1] = negative.get(i);
            }
            int index = negative.size() * 2;
            for (int i = negative.size(); i < positive.size(); i++) {
                arr[index] = positive.get(i);
                index++;
            }
        } else {
            for (int i = 0; i < positive.size(); i++) {
                arr[2 * i] = positive.get(i);
                arr[2 * i + 1] = negative.get(i);
            }
            int index = positive.size() * 2;
            for (int i = positive.size(); i < negative.size(); i++) {
                arr[index] = negative.get(i);
                index++;
            }
        }
    }

    public static void main(String[] args) {
        int arr[] = { 3, 1, -2, -5, 2, -4 };
        // pattern
        // 3,-2,1,-5,2,-4
        // + - + - + -
        // even +ve
        // odd -ve

        rearrange(arr);
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + " ");
        }
        System.out.println();

        int ans[] = rearrangeArray(arr);
        for (int i = 0; i < ans.length; i++) {
            System.out.print(arr[i] + " ");
        }
        System.out.println();

        int arr2[] = { 3, 1, -2, 7, 2, -4, 5, 8, 10 };
        rearrange2(arr2);
        for (int i = 0; i < arr2.length; i++) {
            System.out.print(arr2[i] + " ");
        }

    }
}
