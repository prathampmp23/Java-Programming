package Sum;
import java.util.*;
public class SumofArguments {

 public static void SumofNum(int n){
    int sum=0;
    while(n > 0){
        int lastDigit = n % 10;
            sum = sum + lastDigit;
            n = n/10;
    }
    System.out.println("Sum of Arguments of numbers is :" + sum);
}
public static void main(String args[]){
    Scanner sc = new Scanner(System.in);
    System.out.println("Enter the numbers :");
    int n = sc.nextInt();
    sc.close();
    SumofNum(n);
    }
}
