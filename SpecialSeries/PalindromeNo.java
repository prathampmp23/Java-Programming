import java.util.Scanner;

public class PalindromeNo {

    public static boolean palindrome(int num) {
        int number = num;
        int reverse = 0;
        int remainder = 0;
        while (num > 0) {
            remainder = num % 10;
            reverse = (reverse * 10) + remainder;
            num /= 10;
        }
        if (reverse == number) {
            return true;
        }
        return false;
    }

    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the number");
        int num = sc.nextInt();
        System.out.println("Given no is Palindrome " + palindrome(num));
        sc.close();
    }
}
