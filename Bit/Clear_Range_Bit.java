package Bit;

import java.util.Scanner;

public class Clear_Range_Bit {
    public static int ClearbitinRange(int n , int i , int j){
        int a = ((~0)<<(j+1));
        int b = (1<<i)-1;
        int Bitmask = a | b;
        return n & Bitmask;
    }
    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the number :");
        int n = sc.nextInt();
        System.out.println("Enter the value of i Bit :");
        int i = sc.nextInt();
        System.out.println("Enter the value of j Bit :");
        int j = sc.nextInt();
        sc.close();
        System.out.println(ClearbitinRange(n,i,j));
    }
}
