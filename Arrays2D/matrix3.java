package Arrays2D;

import java.util.*;
/*
*Program for 2D matrix input 
*/
public class matrix3 {
    public static void main(String args[]) {
        try (Scanner sc = new Scanner(System.in)) {
            int arr[][] = new int[3][3];
            for(int i=0;i<3;i++) {
                for(int j=0;j<3;j++) {
                    System.out.println("Enter the number at index :" +i+j);
                    arr[i][j]=sc.nextInt();
                }
            }
        System.out.println("Your entered this matrix");
           for(int i=0;i<3;i++) {
                for(int j=0;j<3;j++) {
                    System.out.print( arr[i][j] +" ");
                }
            System.out.println();
            }
        }
    }
}