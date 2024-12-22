import java.util.Scanner;

public class Hello {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Hello, World!");

        System.out.println("Enter value of n :");
        int sum = 0;
        int n = sc.nextInt();

        for (int i = 0; i <= n; i++) {
            sum += 2 * i;
        }
        System.out.println("sum of n even number :" + sum);
        sc.close();
    }
}