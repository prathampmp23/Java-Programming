package Bit;
import java.util.Scanner;
public class Clear_last_Bit {
    public static int ClearlastBit(int n , int i){
        int Bitmask = (~0)<<i;  // ~0 = -1
        return n & Bitmask;
    }
    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the number :");
        int n = sc.nextInt();
        System.out.println("Enter the value of i Bit :");
        int i = sc.nextInt();
        sc.close();
        System.out.println(ClearlastBit(n,i));
    }
}
