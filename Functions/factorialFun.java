import java.util.*;

public class factorialFun {
    public static void Factorial(int f) {
        int factorial = 1;
        if (f < 0) {
            System.out.println("not a valid Number");
            return;
        }
        if (f == 0) {
            System.out.println("Factorial of 0 is :" + factorial);
            return;
        }
        for (int i = 1; i <= f; i++) {
            factorial = factorial * i;
        }
        System.out.println("Factorial is :" + factorial);
    }

    public static void main(String args[]) {
        try (Scanner sc = new Scanner(System.in)) {
            System.out.println("Enter the number");
            int f = sc.nextInt();
            // calling function
            Factorial(f);

        }
    }
}