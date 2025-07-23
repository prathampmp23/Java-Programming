import java.util.Scanner;
public class ArmstrongNumber {
    public static boolean isArmstrong(int num) {
        int original = num;
        int n = String.valueOf(num).length(); // number of digits
        int sum = 0;

        while (num > 0) {
            int digit = num % 10;
            sum += Math.pow(digit, n);
            num /= 10;
        }

        return sum == original;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter a number: ");
        int number = sc.nextInt();

        if (isArmstrong(number)) {
            System.out.println(number + " is an Armstrong number.");
        } else {
            System.out.println(number + " is not an Armstrong number.");
        }
        sc.close();
        System.out.println("Armstrong number between 1 to 10000 = ");
        for (int i = 1; i <= 10000; i++) {
            if (isArmstrong(i)) {
                System.out.print(i + " ");
            }
        }
    }
}
