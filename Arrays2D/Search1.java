package Arrays2D;

import java.util.*;
public class Search1 {
    public static boolean Search(int matrix[][] , int key){
        for(int i=0; i<matrix.length; i++){       //row
            for(int j=0; j<matrix[0].length; j++){    //column
                if(matrix[i][j] == key) {
                    System.out.println("Key is found at index :"+"("+i+","+j+")");
                    return true;
                }
            }
        }
        System.out.println("key is not find ");
        return false;
    }
    public static void main(String args[]){
        Scanner sc = new Scanner(System.in);
        int matrix[][] = new int[3][3];

        //to represent rows
        int row = matrix.length;
        //to represent column
        int col = matrix[0].length;

        // to get inputs
        for(int i=0; i<row; i++){
            for(int j=0; j<col; j++){
                matrix[i][j] = sc.nextInt();
            }
        }
        //to show output
        for(int i=0; i<row; i++){
            for(int j=0; j<col; j++){
                System.out.print(matrix[i][j]+ " ");
            }
            System.out.println();
        }
        sc.close();
        Search(matrix,6);
    }
}
