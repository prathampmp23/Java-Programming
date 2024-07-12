import java.util.*;
public class AverageFun {
    public static int Average(int a, int b, int c) {
        return (a+b+c)/3;
    }
    public static void main(String args[]) {
        try (Scanner in = new Scanner(System.in)) {
            System.out.println("Enter the number");
            int a = in.nextInt();
            int b = in.nextInt();
            int c = in.nextInt();

            System.out.println("Average of the number is :" +Average(a,b,c));
        }
    }
}