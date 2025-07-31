package Arrays1D;

public class Rotate90Degrees {

    public static void rotate(int[][] matrix) {
        for (int i = 0; i < matrix.length; i++) {
            for (int j = i; j < matrix[0].length; j++) {
                swap(matrix, i, j);
            }
        }

        for (int i = 0; i < matrix.length; i++) {
            reverse(matrix, i, matrix[0].length - 1);
        }
    }

    public static void swap(int arr[][], int i, int j) {
        int temp = arr[i][j];
        arr[i][j] = arr[j][i];
        arr[j][i] = temp;
    }

    public static void reverse(int arr[][], int i, int j) {
        int idx = 0;
        while (idx < j) {
            int temp = arr[i][j];
            arr[i][j] = arr[i][idx];
            arr[i][idx] = temp;
            idx++;
            j--;
        }
    }

    public static void main(String[] args) {
        int matrix[][] = { { 1, 2, 3 }, { 4, 5, 6 }, { 7, 8, 9 } };
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                System.out.print(matrix[i][j] + " ");
            }
            System.out.println();
        }
        System.out.println("Rotated Matrix 90 degree = ");
        rotate(matrix);

        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                System.out.print(matrix[i][j] + " ");
            }
            System.out.println();
        }
    }
}
