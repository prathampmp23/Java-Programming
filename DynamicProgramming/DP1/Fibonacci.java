package DynamicProgramming.DP1;

public class Fibonacci {

    // Using recursion - has higher time complexity
    // Thats why it is inefficient
    public static int fibo(int n) {
        if (n == 0 || n == 1) {
            return n;
        }
        return fibo(n - 1) + fibo(n - 2);
    }

    // Using Dynamic programming
    public static int fiboOptimize(int n, int fib[]) {
        if (n == 0 || n == 1) {
            return n;
        }

        // fib[n] is already claculated
        if (fib[n] != 0) {
            return fib[n];
        }
        // if not calculted store it for other calls
        fib[n] =  fiboOptimize(n - 1, fib) + fiboOptimize(n - 2, fib);
        return fib[n];
    }

    /*

    call stack -> 

     * fiboOptimize(5)
        → fib[5] = fiboOptimize(4) + fiboOptimize(3)

            fiboOptimize(4)
            → fib[4] = fiboOptimize(3) + fiboOptimize(2)

                fiboOptimize(3)
                → fib[3] = fiboOptimize(2) + fiboOptimize(1)

                    fiboOptimize(2)
                    → fib[2] = fiboOptimize(1) + fiboOptimize(0)
                            = 1 + 0 = 1 → fib[2] = 1

                    fiboOptimize(1)
                    → return 1

                fib[3] = 1 (fib[2]) + 1 = 2

                fiboOptimize(2) → already computed → fib[2] = 1 (used directly)

            fib[4] = 2 (fib[3]) + 1 (fib[2]) = 3

            fiboOptimize(3) → already computed → fib[3] = 2 (used directly)

        fib[5] = 3 (fib[4]) + 2 (fib[3]) = 5

     */

     // Using Tabulation 
    public static int fiboTabulation(int n) {
        int dp[] = new int[n+1];
        dp[0] = 0;
        dp[1] = 1;
        for (int i = 2; i <= n; i++) {
            dp[i] = dp[i-1] + dp[i-2];
        }
        // ans
        return dp[n];
    }

    public static void main(String[] args) {
        int n = 10;
        System.out.println("Fibonacci of number using recursion = "+fibo(n));

        int fib[] = new int[n+1]; // by default initialize to 0 in all index
        System.out.println("Fibonacci of number using DP = "+fiboOptimize(n, fib));
        System.out.println("Fibonacci of number using Tabulation = "+fiboTabulation(n));
    }

}
