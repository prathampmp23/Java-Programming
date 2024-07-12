package Bit;

import java.util.Scanner;

public class Update_ith_Bit {
    public static int Clearbit(int n , int i){
        int Bitmask = ~(1<<i);
        return n & Bitmask;
    }
    public static int setBit(int n , int i){
        int Bitmask = 1<<i;
        return n | Bitmask;
    }
    public static int UpdateBit(int n , int i , int NewBit){
        if(NewBit == 0){
            return Clearbit(n,i);
        } else {
            return setBit(n,i);
        }
        // Or Another Approach
        // n = Clearbit(n,i);
        // int Bitmask = NewBit<<i;
        // return n | Bitmask;
    }
    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the number :");
        int n = sc.nextInt();
        System.out.println("Enter the value of i Bit :");
        int i = sc.nextInt();
        System.out.println("Enter the value of NewBit :");
        int NewBit = sc.nextInt();
        sc.close();
        System.err.println(UpdateBit(n,i,NewBit));
    }
}
