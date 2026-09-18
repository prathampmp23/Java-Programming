import java.util.Scanner;

public class CoverInWater {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int t = sc.nextInt();

        while (t-- > 0) {
            int n = sc.nextInt();
            String s = sc.next();

            int maxcnt = 0;
            for (int i = 0; i < n; i++) {
                int cnt = 0;

                while (i< n && s.charAt(i) == '.') {
                    cnt++;
                    i++;
                }
                maxcnt = Math.max(maxcnt, cnt);
            }
            if (maxcnt >= 3)
                System.out.println(2);
            else {
                int ans = 0;
                for (int i = 0; i < n; i++) {
                    int cnt = 0;

                    while (i < n && s.charAt(i) == '.') {
                        cnt++;
                        i++;
                    }
                    ans += cnt;
                }
                System.out.println(ans);
            }
        }

        sc.close();
    }
}
