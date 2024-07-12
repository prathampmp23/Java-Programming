import java.util.*;
public class productfunction {
    public static int Product(int a, int b) {
        return a*b;
    }
    public static void main(String args[]) {
        try (Scanner sc = new Scanner(System.in)) {
            int a = sc.nextInt();
            int b = sc.nextInt();
            System.out.println( "Product of two number is " +Product(a,b));
        }

    }
}