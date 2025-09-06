public class powerofNo {
    public static int power(int x, int n) {
        if (n == 0) {
            return 1;
        }
        return x * power(x, n - 1);
    }

    public static int Optimizedpower(int x, int n) {
        // It has complexity of logn
        if (n == 0) {
            return 1;
        }
        int halfpower = Optimizedpower(x, n / 2);
        // if it is Even
        int halfpowerSq = halfpower * halfpower;
        // if it is odd
        if (n % 2 != 0) {
            halfpowerSq = x * halfpowerSq;
        }
        return halfpowerSq;
    }

    // to handle (-ve) power also
    public static double myPow(double x, int n) {
        long N = n;
        if (N < 0) {
            x = 1 / x;
            N = -N;
        }
        return fastPow(x, N);
    }

    public static double fastPow(double x, long n) {
        if (n == 0) {
            return 1.0;
        }
        double half = fastPow(x, n / 2);
        if (n % 2 == 0) {
            return half * half;
        } else {
            return half * half * x;
        }
    }

    public static void main(String args[]) {
        // Give input in the form of x^n
        System.out.println(Optimizedpower(2, 10));
    }
}
