package Bit;

import java.util.Scanner;

public class Get_ith_Bit {

    public static int getBit(int n , int i){
        int Bitmask = 1<<i;
        if((n & Bitmask) == 0) {
            return 0;
        } else {
            return 1;
        }
    }
    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the number :");
        int n = sc.nextInt();
        System.out.println("Enter the value of i Bit :");
        int i = sc.nextInt();
        sc.close();
        System.err.println(getBit(n,i));
    }
}
