package Bit;

import java.util.Arrays;

public class CountCoprime {
    // ** Sieve of Eratosthenes ** :
    // This algorithm marks all multiples of each prime as
    // composite efficiently, giving a time complexity of: O(nloglogn)
    public static int countPrimes(int n) {
        if (n <= 2)
            return 0;

        boolean[] isPrime = new boolean[n];
        Arrays.fill(isPrime, true);

        // 0 and 1 are not primes
        isPrime[0] = false;
        isPrime[1] = false;

        for (int i = 2; i * i < n; i++) {
            if (isPrime[i]) {
                // T.c = Nlog(logn) --> Prime harmonic series
                // Start from i*i (smaller multiples already marked)
                for (int j = i * i; j < n; j += i) {
                    isPrime[j] = false;
                }
            }
        }

        int count = 0;
        for (int i = 2; i < n; i++) {
            if (isPrime[i])
                count++;
        }

        return count;
    }

    public static void main(String[] args) {
        System.out.println(countPrimes(10));
    }
}
