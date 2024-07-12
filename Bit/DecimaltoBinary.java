package Bit;
import java.util.*;
public class DecimaltoBinary {
    public static void DecBin(int n){
        int myNum  = n;
        int pow =0;
        int Bin =0;
        while(n > 0){
            int rem = n % 2;
            Bin = Bin + (rem * (int)Math.pow(10,pow));
            pow++;
            n = n/2;
        }
        System.out.println("Decimal to "+ myNum +" is :"+ Bin);
    }

    public static void main(String args[]){
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the Decimal number :");
        int n = sc.nextInt();
        sc.close();
        DecBin(n);
    }
}