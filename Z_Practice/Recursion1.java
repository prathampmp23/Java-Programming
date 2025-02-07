package Z_Practice;

public class Recursion1 {
    public static void printDec(int n) {
        // Base Case
        if (n == 1) {
            System.out.print(n);
            return;
        }
        System.out.print(n + " ");
        // Recursive function
        printDec(n - 1);
    }

    public static void printInc(int n) {
        // Base Case
        if (n == 1) {
            System.out.print(n + " ");
            return;
        }
        // Recursive function
        printInc(n - 1);
        System.out.print(n + " ");
    }

    public static int factorial(int n) {
        if (n == 0) {
            return 1;
        }
        int fNm1 = factorial(n - 1);
        int fN = n * fNm1;
        return fN;
    }

    public static int sumOfNaturalNo(int n) {
        if (n == 1) {
            return 1;
        }
        int SumNm1 = sumOfNaturalNo(n - 1);
        int SumN = n + SumNm1;
        return SumN;
    }

    public static int fibonacci(int n) {
        // time complexity - O(2^n) exponential
        if (n == 0 || n == 1) {
            return n;
        }
        int fibNm1 = fibonacci(n - 1);
        int fibNm2 = fibonacci(n - 2);
        int fibN = fibNm1 + fibNm2;
        return fibN;
    }

    public static boolean isSorted(int arr[], int i) {
        // Base case
        if (i == arr.length - 1) {
            return true;
        }
        if (arr[i] > arr[i + 1]) {
            return false;
        }
        return isSorted(arr, i + 1);
    }

    public static int firstOccurence(int arr[], int i, int key) {
        if (i == arr.length - 1) {
            return -1;
        }
        if (arr[i] == key) {
            return i;
        }
        return firstOccurence(arr, i + 1, key);
    }

    public static int lastOccurence(int arr[], int i, int key) {
        if (i == arr.length - 1) {
            return -1;
        }
        int isFound = lastOccurence(arr, i + 1, key);
        if (isFound == -1 && arr[i] == key) {
            return i;
        }
        return isFound;
    }

    public static int power(int x, int n) {
        if (n == 0) {
            return 1;
        }
        return x * power(x, n - 1);
    }

    public static int optimizedPower(int x, int n) {
        if (n == 0) {
            return 1;
        }
        // Time complexity => O(n)
        // Here funtion is called 2 times to calculate half power
        // int halfPowerSq = optimizedPower(x, n / 2) * optimizedPower(x, n / 2);

        // Now, Time complexity => O(logn)
        // Here funtion is called 1 times only to calculate half power
        int halfpow = optimizedPower(x, n / 2);
        int halfPowerSq = halfpow * halfpow;
        // n is odd
        if (n % 2 != 0) {
            halfPowerSq = x * halfPowerSq;
        }
        return halfPowerSq;
    }

    public static void main(String[] args) {
        printDec(10);
        System.out.println();
        printInc(10);
        System.out.println();
        System.out.println("Factorial = " + factorial(5));
        System.out.println("Sum = " + sumOfNaturalNo(10));
        System.out.println("Fibonacci = " + fibonacci(6));
        int arr[] = { 1, 2, 3, 4, 5 };
        System.out.println("Array is sorted = " + isSorted(arr, 0));
        int arrys[] = { 1, 4, 5, 8, 5, 7, 6 };
        System.out.println("First occurence  = " + firstOccurence(arrys, 0, 5));
        System.out.println("Last occurence  = " + lastOccurence(arrys, 0, 5));
        System.out.println("Optimized power = " + optimizedPower(2, 10));
        System.out.println("Power = " + power(2, 10));
    }
}
