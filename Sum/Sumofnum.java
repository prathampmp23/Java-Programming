package Sum;
// To find the sum of numbers
import java.util.*;
public class Sumofnum {
    public static void main(String args[])
    {
        int n,sum = 0;
        try (Scanner s = new Scanner(System.in)) {
            System.out.println("Enter the number");
            n = s.nextInt();
        }
        for(int i=1;i<=n;i++){
            sum+=i;     //sum = sum+i;    
        }
        System.out.println(sum);
    }
}