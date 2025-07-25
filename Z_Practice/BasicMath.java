package Z_Practice;

public class BasicMath {

    // O(logN)
    public static int countDigit(int n) {
        int count = 0;
        while (n > 0) {
            count++;
            n = n / 10;
        }
        return count;
    }

    public static int countDigit2(int n) {
        int count = (int) Math.log10(n) + 1;
        return count;
    }

    public static int reverseNo(int n) {
        int reverse = 0;
        while (n > 0) {
            int lastDigit = n % 10;
            reverse = reverse * 10 + lastDigit;
            n = n / 10;
        }
        return reverse;
    }

    public static boolean isPalindrome(int n) {
        int original = n;
        int reverse = 0;
        while (n > 0) {
            int lastDigit = n % 10;
            reverse = reverse * 10 + lastDigit;
            n = n / 10;
        }
        return original == reverse;
    }

    public static boolean isArmstrongNo(int n) {
        int count = (int) Math.log10(n) + 1;
        // or
        // int count = String.valueOf(n).length();
        int original = n;
        int sum = 0;
        while (n > 0) {
            int lastDigit = n % 10;
            sum += Math.pow(lastDigit, count);
            n = n / 10;
        }
        return original == sum;
    }

    // O(n)
    public static void printDivisors(int n) {
        // code here
        for (int i = 1; i <= n; i++) {
            if (n % i == 0) {
                System.out.print(i + " ");
            }
        }
    }

    // O(sqrt(n))
    public static void printDivisorsOptimize(int n) {
        // for (int i = 1; i <= Math.sqrt(n); i++) {
        // another way of writing Math.sqrt(n)
        for (int i = 1; i * i <= n; i++) {
            if (n % i == 0) {
                System.out.print(i + " ");
                if (n / i != i) {
                    System.out.print(n / i + " ");
                }
            }
        }
    }

    public static boolean isPrime(int n) {
        int count = 0;
        for (int i = 1; i <= n; i++) {
            if (n % i == 0) {
                count++;
            }
        }
        if (count == 2)
            return true;
        return false;
    }

    public static boolean isPrimeOptimized(int n) {
        int count = 0;
        for (int i = 1; i <= Math.sqrt(n); i++) {
            if (n % i == 0) {
                count++;
            }
        }
        if (count == 2)
            return true;
        return false;
    }

    public static int gcd(int a, int b) {
        while (a > 0 && b > 0) {
            if (a > b) a = a % b;
            else b = b % a;
        }
        if(a == 0) return b;
        return a;
    }

    public static void main(String[] args) {
        System.out.println(countDigit(7784));
        System.out.println(countDigit2(7784));
        System.out.println(reverseNo(7784));
        System.out.println(isPalindrome(787));
        System.out.println(isArmstrongNo(153));
        printDivisors(36);
        System.out.println();
        printDivisorsOptimize(36);
        System.out.println();
        System.out.println(isPrime(13));
        System.out.println(isPrime(13));
        System.out.println(gcd(40, 20));
    }
}
