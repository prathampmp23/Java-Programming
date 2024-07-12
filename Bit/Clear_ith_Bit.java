package Bit;

import java.util.Scanner;

public class Clear_ith_Bit {
    public static int Clearbit(int n , int i){
        int Bitmask = ~(1<<i);
        return n & Bitmask;
    }
    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the number :");
        int n = sc.nextInt();
        System.out.println("Enter the value of i Bit :");
        int i = sc.nextInt();
        sc.close();
        System.err.println(Clearbit(n,i));
    }
}
