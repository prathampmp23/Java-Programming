package Bit;
import java.util.Scanner;
public class CheckNum {
    public static void OddorEven(int n){
        int Bitmask = 1;
        if((n & Bitmask) == 0) {
            //Even number
            System.out.println("Even Number");
        } else{
            //Odd number
            System.out.println("Odd Number");
        }
    }
    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the number :");
        int n = sc.nextInt();
        sc.close();
        OddorEven(n);
    }
}
