package Z_Practice;

import java.util.Scanner;


public class Arrays2D {

    public static boolean search(int matrix[][], int key) {
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                if (matrix[i][j] == key) {
                    System.out.println("Found at index (" + i + "," + j + ")");
                    return true;
                }
            }
        }
        System.out.println("Element not found.");
        return false;
    }

    public static void largest(int matrix[][]) {
        int largest = Integer.MIN_VALUE;

        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                if (matrix[i][j] > largest) {
                    largest = matrix[i][j];
                }
            }
        }
        System.out.println("Largest element in matrix = " + largest);
    }

    public static void smallest(int matrix[][]) {
        int smallest = Integer.MAX_VALUE;

        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                if (matrix[i][j] < smallest) {
                    smallest = matrix[i][j];
                }
            }
        }
        System.out.println("Smallest element in matrix = " + smallest);

    }

    public static void spiralMatrix(int matrix[][]) {
        int startRow = 0;
        int startCol = 0;
        int endRow = matrix.length - 1;
        int endCol = matrix[0].length - 1;

        while (startRow <= endRow && startCol <= endCol) {
            // Top
            for (int j = startCol; j <= endCol; j++) {
                System.out.print(matrix[startRow][j] + " ");
            }
            // Right
            for (int i = startRow + 1; i <= endRow; i++) {
                System.out.print(matrix[i][endCol] + " ");
            }
            // Bottom
            for (int j = endCol - 1; j >= startCol; j--) {
                // do not print the same element which is print by top
                if (startRow == endRow) {
                    break;
                }
                System.out.print(matrix[endRow][j] + " ");
            }
            // Left
            for (int i = endRow - 1; i >= startRow + 1; i--) {
                // do not print the same element which is print by right
                if (startCol == endCol) {
                    break;
                }
                System.out.print(matrix[i][startCol] + " ");
            }
            startRow++;
            startCol++;
            endRow--;
            endCol--;
        }
        System.out.println();
    }

    public static int diagonalSum(int matrix[][]) {
        int sum = 0;
        // ***Brute force  - Time Complexity = O(n^2)
        // for (int i = 0; i < matrix.length; i++) {
        //     for (int j = 0; j < matrix[0].length; j++) {
        //         // Primary Diagonal (i == j)
        //         if (i == j) {
        //             sum += matrix[i][j];
        //         } // Secondary Diagonal (i+j == n-1)
        //         else if (i + j == matrix.length - 1) {
        //             sum += matrix[i][j];
        //         }
        //     }
        // }

        // ***Optimal code - Linear time complexity code = O(n)
        for (int i = 0; i < matrix.length; i++) {
            // primary diagonal
            sum += matrix[i][i];

            // secondary diagonal
            // overlaping condition
            if (i != matrix.length - 1 - i) // (matrix.length - 1 - i)== j
                sum += matrix[i][matrix.length - 1 - i];
        }
        return sum;
    }

    public static boolean stairCaseSearch(int matrix[][], int key) {
        int row = 0, col = matrix[0].length - 1; // for (0, m-1) element 

        while (row < matrix.length && col >= 0) {
            if (matrix[row][col] == key) {
                System.out.println("Key found at index (" + row + "," + col + ") ");
                return true;
            } else if (key < matrix[row][col]) {
                // to move left
                col--;
            } else {
                // to move bottom
                row++;
            }
        }
        System.out.println("Key not found!");
        return false;
    }
    public static boolean stairCaseSearch2(int matrix[][], int key) {
        int row = matrix.length - 1, col = 0; // for (n-1, 0) element

        while (row >= 0 && col <  matrix[0].length) {
            if (matrix[row][col] == key) {
                System.out.println("Key found at index (" + row + "," + col + ") ");
                return true;
            } else if (key < matrix[row][col]) {
                // to move Top
                row--;
            } else {
                // to move right
                col++;
            }
        }
        System.out.println("Key not found!");
        return false;
    }

    public static void findOccurence(int matrix[][], int num) {
        int count = 0;
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                if(matrix[i][j] == num) {
                    count++;
                }
            }
        }
        System.out.println("No of occurence of " + num + " is = " + count);
    }

    public static void findTranspose(int matrix[][]) {
        int transposeArr[][] = new int[matrix[0].length][matrix.length];
        // Transpose 
        for (int i = 0; i < transposeArr.length; i++) {
            for (int j = 0; j < transposeArr[0].length; j++) {
                transposeArr[i][j] = matrix[j][i];
            }
        }
        // To print
        for (int i = 0; i < transposeArr.length; i++) {
            for (int j = 0; j < transposeArr[0].length; j++) {
                System.out.print(transposeArr[i][j]+ " ");
            }
            System.out.println();
        }

    }

    public static void main(String[] args) {
        int n = 3, m = 3;
        int matrix[][] = new int[n][m];
        // n -> row , m -> column
        // 'rows' = matrix.length;
        // 'cols' = matrix[0].length;
        Scanner sc = new Scanner(System.in);

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                System.out.print("Enter element at index (" + i + "," + j + ") ");
                matrix[i][j] = sc.nextInt();
            }
        }
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                System.out.print(matrix[i][j] + " ");
            }
            System.out.println();
        }
        sc.close();


        // To search key in matrix
        search(matrix, 5);

        // Print largest
        largest(matrix);

        // Print Smallest
        smallest(matrix);

        // Spiral matrix
        int Spiralmatrix[][] = {
                { 1, 2, 3, 4 },
                { 5, 6, 7, 8 },
                { 9, 10, 11, 12 },
                { 13, 14, 15, 16 }
        };
        System.out.println("Spiral matrix : ");
        spiralMatrix(Spiralmatrix);

        // Diagonal Sum
        System.out.println("Diagonal sum of matrix is : " + diagonalSum(Spiralmatrix));

        // Staire Case (Search in sorted array)
        int stairCasematrix[][] = {
                { 10, 20, 30, 40 },
                { 15, 25, 35, 45 },
                { 27, 29, 37, 48 },
                { 32, 33, 39, 50 }
        };
        stairCaseSearch(stairCasematrix, 33);
        stairCaseSearch2(stairCasematrix, 30);

        // To find occurence of number in array
        int arr2[][] = { {4,7,8},{8,8,7} };
        findOccurence(arr2, 7);

        int[][] nums = { {1,4,9},{11,4,3},{2,2,3} };
        int sum = 0;
        // Sum of 2 row elements
        for (int j = 0; j < nums[0].length; j++) {
            sum += nums[1][j];
        }
        System.out.println("Sum of second row elements is = " + sum);

        // To find Transpose
        int transpose[][] = { {1,2,3},{2,4,6} };
        System.out.println("Before transpose");
        for (int i = 0; i < transpose.length; i++) {
            for (int j = 0; j < transpose[0].length; j++) {
                System.out.print(transpose[i][j]+ " ");
            }
            System.out.println();
        }
        System.out.println("After transpose");
        findTranspose(transpose);

    }
}
