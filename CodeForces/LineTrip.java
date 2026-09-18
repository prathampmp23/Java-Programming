import java.util.Arrays;
import java.util.Scanner;

public class LineTrip {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int t = sc.nextInt();

        while (t-- > 0) {
            int n = sc.nextInt();
            int x = sc.nextInt();

            int[] arr = new int[n];

            for (int i = 0; i < n; i++) {
                arr[i] = sc.nextInt();
            }

            Arrays.sort(arr);

            int maxdiff = arr[0];

            for (int i = 1; i < n; i++) {
                maxdiff = Math.max(maxdiff, arr[i] - arr[i - 1]);
            }

            maxdiff = Math.max(maxdiff, 2 * (x - arr[n - 1]));

            System.out.println(maxdiff);
        }

        sc.close();
    }
}