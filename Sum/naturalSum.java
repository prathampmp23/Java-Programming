package Sum;
import java.util.*;
class naturalSum {
    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        int n,sum=0;
        System.out.println("Enter the number :");
        n=sc.nextInt();
        sc.close();
        for(int i=1;i<=n;i++) {
            sum = sum + i; // sum += i;  
        }
        System.out.println("Sum is :"+sum);
    }
}