package Arrays2D;

import java.util.*;
// To search element in 2D Array
class Search {
    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the Row :");
        int row = sc.nextInt();
        System.out.println("Enter the Column");
        int col = sc.nextInt();
        int[][] matrix = new int[row][col];
        System.out.println("Enter the inputs :");
        // For Inputs
        for(int i=0;i<row;i++) {
            for(int j=0;j<col;j++) {
                matrix[i][j] = sc.nextInt();
            }
        }
        System.out.println("Outputs are :");
        // For Output
        for(int i=0;i<row;i++) {
            for(int j =0;j<col;j++) {
                System.out.print(matrix[i][j] +" ");
            }
        System.out.println();
        }
        // To find the number at its index
        System.out.println("Enter the number x to search :");
        int x = sc.nextInt();
        sc.close();
        for(int i=0;i<row;i++) {
            for(int j =0;j<col;j++) {
                if(matrix[i][j] == x) {
                    System.out.println("The number is find at index : ("+i+","+j+")");
                }
            }
        }
    }
}