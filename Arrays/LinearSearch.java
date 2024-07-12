package Arrays;
import java.util.*;
//Program to Search Element in Array 
//**Linear Search**//
public class LinearSearch {
    public static void main(String[] args) {
        try (Scanner sc = new Scanner(System.in)) {
            System.out.println("Enter the size of array");
            int size = sc.nextInt();
            int arr[] = new int[size];
            System.out.println("Enter the elements in Array");
            for(int i=0;i<size;i++) {
                arr[i] = sc.nextInt();
            }
            System.out.println("Enter the number to find in array");
            int x = sc.nextInt();
            for( int i=0;i<size;i++) {
                if(x==arr[i]) {
                    System.out.println("Your element is at index : "+i);
                }
            }
        }
    }
}
