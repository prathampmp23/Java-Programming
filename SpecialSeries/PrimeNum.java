import java.util.*;

public class PrimeNum {
    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the number :");
        int n = sc.nextInt();
        sc.close();
        if (n == 2) {
            System.out.println("Number is Prime");
        } else {
            boolean isPrime = true;
            for (int i = 2; i <= Math.sqrt(n); i++) {   // optimization for (i <= n-1 )
                if (n % i == 0) {    // means n is multiple of i (i not equal to 1 or n)
                    isPrime = false;    // hence it is composite not prime number
                }
            }
            if (isPrime == true) {
                System.out.println("Number is prime");
            } else {
                System.out.println("Number is not prime");
            }
        }
    }
}
