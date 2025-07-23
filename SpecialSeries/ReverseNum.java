
import java.util.*;

public class ReverseNum {
    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the number : ");
        int n = sc.nextInt();
        sc.close();

        // to print reverse of number 1 method
        while (n > 0) {
            int lastDigit = n % 10;
            System.out.print(lastDigit + "");
            n /= 10; // n = n/10;
        }

        // to print reverse of same number 2 method
        int rev = 0;
        while (n > 0) {
            int lastDigit = n % 10;
            rev = (rev * 10) + lastDigit;
            n = n / 10;
        }
        System.out.println(rev);
    }
}