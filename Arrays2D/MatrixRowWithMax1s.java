package Arrays2D;

public class MatrixRowWithMax1s {
    public static int rowWithMax1s(int[][] matrix) {
        int prevCnt = 0;
        int row = -1;
        for (int i = 0; i < matrix.length; i++) {
            int currCnt = 0;
            for (int j = 0; j < matrix[0].length; j++) {
                if (matrix[i][j] == 1) {
                    currCnt++;
                }
                if (prevCnt < currCnt) {
                    prevCnt = currCnt;
                    row = i;
                }
            }
        }
        return row;
    }

    public static void main(String[] args) {
        int matrix[][] = { { 0, 1, 1, 1 }, { 1, 1, 1, 1 }, { 0, 0, 0, 1 } };
        System.out.println("Row with max 1's = " + rowWithMax1s(matrix));
    }
}
