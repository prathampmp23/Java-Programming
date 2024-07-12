package Arrays2D;
/*
* Program for 1D Array input
*/
import java.util.*;
public class matrix2 {
    public static void main(String args[]) {
        try (Scanner sc = new Scanner(System.in)) {
            int a[] =new int[6];
            for(int i=0;i<=5;i++) {
                System.out.println("Enter the number :");
                a[i]=sc.nextInt();
            }
            for(int i=0;i<=5;i++) {
                System.out.println("Element at index "+ i +" is "+ a[i]);
            }
        }
    }
}
