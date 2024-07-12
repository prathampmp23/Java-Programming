import java.util.Scanner;
public class MaxNoFun {
    public static void maxArray(int num , int num1){
        int Max = Math.max(num, num1);
        System.out.println("Maximum number is "+ Max);
    }

    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        int num = sc.nextInt();
        int num1 = sc.nextInt();
        sc.close();
        maxArray(num, num1);
    }
}
