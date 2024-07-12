package SpecialSeries;
import java.util.*;
//Program to find Greatest common divisor
public class GCD {
    public static void main(String args[]) {
            Scanner s = new Scanner(System.in);
            System.out.println("Enter the two number");
            int a=s.nextInt();
            int b=s.nextInt();
            int gcd = 1;
            s.close();
        for(int i=1;i<=a && i<=b;i++) {
            if(a%i ==0 && b%i ==0)
                gcd =i;
            }
   System.out.println("Greatest common divisor : " +gcd);
        }
    }