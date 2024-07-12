import java.util.*;
public class AvgFun {
 public static void SumofNum(int n){
    int sum=0;
    while(n > 0){
        int lastDigit = n % 10;
            sum = sum + lastDigit;
            n = n/10;
    }
    System.out.println(sum);
}

public static void main(String args[]){
    Scanner sc = new Scanner(System.in);
    int n = sc.nextInt();
    sc.close();
    SumofNum(n);
    }
}
