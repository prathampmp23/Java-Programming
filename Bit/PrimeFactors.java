package Bit;

import java.util.ArrayList;
import java.util.List;

public class PrimeFactors {

    public static List<List<Integer>> primeFactors(int[] queries) {
        List<List<Integer>> ans = new ArrayList<>();
        for (int i = 0; i < queries.length; i++) {
            List<Integer> fact = new ArrayList<>();
            fact = primeFactors(queries[i]);
            ans.add(fact);
        }
        return ans;
    }

    public static List<Integer> primeFactors(int n) {
        List<Integer> factors = new ArrayList<>();

        if (n <= 1)
            return factors; // no prime factors for 0 or 1

        // Step 1: Handle factor 2 separately
        while (n % 2 == 0) {
            factors.add(2);
            n /= 2;
        }

        // Step 2: Check odd factors from 3 to sqrt(n)
        for (int i = 3; i * i <= n; i += 2) {
            while (n % i == 0) {
                factors.add(i);
                n /= i;
            }
        }

        // Step 3: If n > 2, then n itself is prime
        if (n > 2)
            factors.add(n);

        return factors;
    }

    // Using ** Sieve of Erathosthenes **
    public static List<List<Integer>> primeFactors2(int[] queries) {
        int max = 0;
        for (int q : queries) {
            max = Math.max(max, q);
        }

        // Precompute SPF up to the largest number
        int[] spf = computeSPF(max);

        // For each query, find its prime factors using the SPF array
        List<List<Integer>> ans = new ArrayList<>();
        for (int n : queries) {
            ans.add(getPrimeFactors(n, spf));
        }

        return ans;
    }

    // Precompute smallest prime factor for each number up to n
    public static int[] computeSPF(int n) {
        int[] spf = new int[n + 1];
        for (int i = 0; i <= n; i++)
            spf[i] = i;

        for (int i = 2; i * i <= n; i++) {
            if (spf[i] == i) { // i is prime
                for (int j = i * i; j <= n; j += i) {
                    if (spf[j] == j)
                        spf[j] = i;
                }
            }
        }
        return spf;
    }

    // Extract prime factors using precomputed SPF
    public static List<Integer> getPrimeFactors(int n, int[] spf) {
        List<Integer> factors = new ArrayList<>();
        if (n <= 1)
            return factors;

        while (n != 1) {
            factors.add(spf[n]);
            n /= spf[n];
        }

        return factors;
    }

    public static void main(String[] args) {
        int[] queries = { 10, 12, 15, 20, 30 };

        List<List<Integer>> result = primeFactors(queries);

        // Print output
        for (int i = 0; i < queries.length; i++) {
            System.out.println("Prime factors of " + queries[i] + ": " + result.get(i));
        }
    }
}
