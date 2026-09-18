import java.util.*;

public class HalloumiBoxes {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while (t-- > 0) {
            int n = sc.nextInt();
            int k = sc.nextInt();

            int arr[] = new int[n];
            boolean flag = true;

            for (int i = 0; i < n; i++) {
                arr[i] = sc.nextInt();
            }
            for (int i = 1; i < arr.length; i++) {
                if (arr[i - 1] > arr[i]) {
                    flag = false;
                    break;
                }
            }
            if (flag)
                System.out.println("YES");
            else if (k <= 1)
                System.out.println("NO");
            else
                System.out.println("YES");
        }
        sc.close();
    }
}
