import java.util.*;
public class sumFunction {
    //function Declaration
    public static int calculateSum(int a,int b) {
        int Sum = a + b ;
        return Sum;
    }
    public static void main(String args[]) {
        try (Scanner sc = new Scanner(System.in)) {
            int a = sc.nextInt();
            int b = sc.nextInt();
            int sum = calculateSum(a,b);
            System.out.println( "sum is "+sum);
        }
    }
}
