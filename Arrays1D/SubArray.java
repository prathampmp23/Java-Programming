package Arrays1D;

import java.util.*;

public class SubArray {

    public static void subArray(int num[]) {
        for (int i = 0; i < num.length; i++) {
            int start = i;
            for (int j = i; j < num.length; j++) {
                int end = j;
                for (int k = start; k <= end; k++) {
                    System.out.print(num[k] + " ");
                }
                System.out.println();
            }
            System.out.println();
        }
    }

    // Brute Force
    public static void MaxsubArraySum(int num[]) {
        int current = 0;
        int MaxSum = Integer.MIN_VALUE; // (-)infinity to check max value
        for (int i = 0; i < num.length; i++) {
            int start = i;
            for (int j = i; j < num.length; j++) {
                int end = j;
                current = 0;
                for (int k = start; k <= end; k++) {
                    // Subarray sum
                    current += num[k];
                }
                System.out.println(current);
                if (MaxSum < current) {
                    MaxSum = current;
                }
            }
        }
        System.out.println("max value is " + MaxSum);
    }

    // Prefix Sum
    public static void PrefixSum(int num[]) {
        int current = 0;
        int MaxSum = Integer.MIN_VALUE;
        int prefix[] = new int[num.length];
        for (int i = 1; i < prefix.length; i++) {
            prefix[i] = prefix[i - 1] + num[i];
        }
        for (int i = 0; i < num.length; i++) {
            int start = i;
            for (int j = i; j < num.length; j++) {
                int end = j;
                // condition(a +,-,*,/,=,<,> b) ? true initalize : false initalize
                current = start == 0 ? prefix[end] : prefix[end] - prefix[start - 1];

                if (MaxSum < current) {
                    MaxSum = current;
                }
            }
        }
        System.out.println("max value is " + MaxSum);
    }

    // Kadane's Algorithm
    public static void KadanesSum(int num[]) {
        int cs = 0;
        int ms = Integer.MIN_VALUE;
        for (int i = 0; i < num.length; i++) {
            cs = cs + num[i];
            if (cs < 0) {
                cs = 0;
            }
            ms = Math.max(cs, ms);
        }
        System.out.println("Max sum is :" + ms);
    }

    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the size :");
        int size = sc.nextInt();
        System.out.println("Enter the element in an array:");
        int num[] = new int[size];
        for (int i = 0; i < num.length; i++) {
            num[i] = sc.nextInt();
        }
        sc.close();
        subArray(num);
        MaxsubArraySum(num);
        // PrefixSum(num);
        // KadanesSum(num);
    }
}
