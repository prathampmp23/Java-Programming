package Bit;
import java.util.*;
public class BinarytoDecimal {
    public static void BinNum(int num){
        int myNum = num;
        int pow=0;
        int Dec=0;
        while(num > 0){
            int lastDigit = num % 10;
            Dec = Dec + (lastDigit * (int)Math.pow(2,pow));
            pow++;
            num = num/10;
        }
        System.out.println("Decimal number of "+ myNum +" is :"+ Dec);
    }

    public static void main(String args[]){
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the Binary number :");
        int n =sc.nextInt();
        sc.close();
        BinNum(n);
    }
}
