import java.util.Scanner;

public class DontTrytoCount {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while (t-- > 0) {
            int n = sc.nextInt();
            int m = sc.nextInt();

            String x = sc.next();
            String s = sc.next();

            int ans = 0;
            while (!x.contains(s) && x.length() <= 100) {
                ans++;
                x = x + x;
            }
            if (x.contains(s))
                System.out.println(ans);
            else
                System.out.println(-1);
        }
        sc.close();
    }
}
