import java.util.*;

public class Factorial {
    public static int fact(int n) {
        if (n == 0) {
            return 1;
        }
        int fm1 = fact(n - 1);
        int fn = n * fm1;
        return fn;
    }

    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the number :");
        int n = sc.nextInt();
        sc.close();
        System.out.println(fact(n));
    }
}
