package Z_Practice;

import java.util.*;

public class CF {
    // public static void main(String[] args) {
    //     Scanner sc = new Scanner(System.in);
    //     int q = sc.nextInt();
    //     for (int t = 0; t < q; t++) {
    //         int n = sc.nextInt();
    //         String s = sc.next();
    //         String tStr = sc.next();

    //         char[] a = s.toCharArray();
    //         char[] b = tStr.toCharArray();
    //         Arrays.sort(a);
    //         Arrays.sort(b);

    //         if (Arrays.equals(a, b))
    //             System.out.println("YES");
    //         else
    //             System.out.println("NO");
    //     }

    //     sc.close();
    // }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while (t-- > 0) {
            int n = sc.nextInt();
            int[] a = new int[n];
            boolean hasOdd = false, hasEven = false;

            for (int i = 0; i < n; i++) {
                a[i] = sc.nextInt();
                if ((a[i] & 1) == 0)
                    hasEven = true;
                else
                    hasOdd = true;
            }

            if (hasOdd && hasEven) {
                Arrays.sort(a);
            }

            StringBuilder sb = new StringBuilder();
            for (int i = 0; i < n; i++) {
                if (i > 0)
                    sb.append(' ');
                sb.append(a[i]);
            }
            System.out.println(sb);
        }
        sc.close();
    }
}
