package Arrays2D;

public class TransposeMatrix2 {
    public static void main(String args[]){
        int matrix[][] = { {2,3,7}, {5,6,7} };
        int row = 2;
        int col = 3;
        System.out.println("original matrix is :");

        // to print original matrix
        for(int i=0; i<row; i++){
            for(int j=0; j<col; j++){
                System.out.print(matrix[i][j]+" ");
            }
            System.out.println();
        }
        
        // Transpose of matrix
        int transpose[][] = new int[col][row];
        for(int i=0; i<row; i++){
            for(int j=0; j<col; j++){
                transpose[j][i] = matrix[i][j];
            }
        }
        System.out.println("Transposed matrix is :");

        // to print transposed matrix
        for(int i=0; i<transpose.length; i++){
            for(int j=0; j<transpose[0].length; j++){
                System.out.print(transpose[i][j]+" ");
            }
            System.out.println();
        }
    }
}
