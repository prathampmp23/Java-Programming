import java.util.Arrays;
import java.util.Scanner;

public class DaytonaCost {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int t = sc.nextInt();

        while (t-- > 0) {
            int n = sc.nextInt();
            int k = sc.nextInt();

            int[] arr = new int[n];

            for (int i = 0; i < n; i++) {
                arr[i] = sc.nextInt();
            }
            boolean isPresent = false;
            for (int i = 0; i < arr.length; i++) {
                if (arr[i] == k) {
                    isPresent = true;
                    break;
                }
            }
            if (isPresent) {
                System.out.println("YES");
            } else {
                System.out.println("NO");
            }
        }

        sc.close();
    }
}
