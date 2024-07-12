package SpecialSeries;
import java.util.*;
public class Factorial {
    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the number :");
        int f = sc.nextInt();
        sc.close();
        int fact =1;
        if(f==0){
            System.out.println("Not a Valid number ");
        }else {
        for(int i=1;i<=f;i++){
            fact = fact * i;
        }
        System.out.println("Factorial of numberis :"+ fact);
        }
    }
}      