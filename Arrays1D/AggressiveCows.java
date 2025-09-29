package Arrays1D;

import java.util.Arrays;
import java.util.Scanner;

public class AggressiveCows {
    public static int aggressiveCows(int arr[], int k, int N) {
        Arrays.sort(arr);
        int low = 1;
        int high = arr[N - 1] - arr[0];

        while (low <= high) {
            int mid = (low + high) / 2;
            if (canWePlace(arr, mid, k)) {
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }
        return high;
    }

    public static boolean canWePlace(int arr[], int dist, int cows) {
        int cntCows = 1;
        int last = arr[0];

        for (int i = 1; i < arr.length; i++) {
            if (arr[i] - last >= dist) {
                cntCows++;
                last = arr[i];
            }
            if (cntCows >= cows)
                return true;
        }
        return false;
    }

    public static void main(String[] args) throws java.lang.Exception {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt(); // number of test cases
        while (t-- > 0) {
            int N = sc.nextInt();
            int C = sc.nextInt();
            int[] stalls = new int[N];
            for (int i = 0; i < N; i++) {
                stalls[i] = sc.nextInt();
            }
            System.out.println(aggressiveCows(stalls, C, N));
        }
        sc.close();
    }
}
