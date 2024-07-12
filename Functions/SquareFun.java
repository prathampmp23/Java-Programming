import java.util.*;
public class SquareFun {
    public static void main(String args[]) {
        int X , n;
        double result;
        try (Scanner s = new Scanner(System.in)) {
            System.out.println("Enter the number in the form of (X)*n");
            System.out.println("Enter the X");;
            X = s.nextInt();
            System.out.println("Enter the Exponent");
            n = s.nextInt();
        }
        result = Math.pow(X, n);
        System.out.println(" The square of number is :"+result);
    }
}