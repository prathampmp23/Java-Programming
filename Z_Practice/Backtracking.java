package Z_Practice;

public class Backtracking {

    public static void printArray(int arr[]) {
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + " ");
        }
        System.out.println();
    }

    public static void changeArray(int arr[], int i, int val) {
        // base case
        if (i == arr.length) {
            printArray(arr);
            return;
        }
        // recursion
        arr[i] = val; // asign value
        changeArray(arr, i + 1, val + 1); // fnx call step
        arr[i] = arr[i] - 2; // backtracking step
    }

    // Find subset
    public static void findSubSet(String str, String ans, int i) {
        // Base case
        if (i == str.length()) {
            if (ans.length() == 0) {
                System.out.println("null");
            } else {
                System.out.println(ans);
            }
            return;
        }
        // Recursion
        // Yes choice
        findSubSet(str, ans + str.charAt(i), i + 1);
        // No choice
        findSubSet(str, ans, i + 1);
    }

    // Permutation 
    public static void permutation(String str, String ans) {
        // base case
        if (str.length() == 0) {
            System.out.println(ans);
            return;
        }
        // recursion
        for (int i = 0; i < str.length(); i++) {
            char curr = str.charAt(i);
            String newStr = str.substring(0, i) + str.substring(i + 1);
            permutation(newStr, ans + curr);
        }
    }

    // N Queens Problem for finding total solution or count no of solutions
    public static void nQueens(char board[][], int row) {
        // Base case
        if (row == board.length) {
            printBoard(board);
            count++;
            return;
        }
        // column loop
        for (int col = 0; col < board.length; col++) {
            if (isSafe(board, row, col)) {
                board[row][col] = 'Q';
                nQueens(board, row + 1); // function call
                board[row][col] = '.'; // backtracking
            }
        }
    }

    public static boolean isSafe(char board[][], int row, int col) {
        // vertical up
        for (int i = row - 1; i >= 0; i--) {
            if (board[i][col] == 'Q') {
                return false;
            }
        }
        // Diagonal left up
        for (int i = row - 1, j = col - 1; i >= 0 && j >= 0; i--, j--) {
            if (board[i][j] == 'Q') {
                return false;
            }
        }
        // Diagonal right up
        for (int i = row - 1, j = col + 1; i >= 0 && j < board.length; i--, j++) {
            if (board[i][j] == 'Q') {
                return false;
            }
        }
        return true;
    }

    public static void printBoard(char board[][]) {
        System.out.println("-- Chess board --");
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board.length; j++) {
                System.out.print(board[i][j] + " ");
            }
            System.out.println();
        }
    }

    // N Queens Problem for checking is solution is exist or not
    public static boolean isNQueenSolExist(char board[][], int row) {
        // Base case
        if (row == board.length) {
            return true;
        }
        // column loop
        for (int col = 0; col < board.length; col++) {
            if (isSafe(board, row, col)) {
                board[row][col] = 'Q';
                if (isNQueenSolExist(board, row + 1)) {
                    return true;
                }
                board[row][col] = '.'; // backtracking
            }
        }
        return false;
    }

    // Grid ways
    public static int gridWays(int i, int j, int n, int m) {
        // Base case
        if (i == n - 1 && j == m - 1) { // condition for last cell
            return 1;
        } else if (i == n || j == m) { // boundary cross condition
            return 0;
        }
        // Down
        int w1 = gridWays(i + 1, j, n, m);
        // Right
        int w2 = gridWays(i, j + 1, n, m);
        return w1 + w2;
    }

    // sudoku Solver
    public static boolean sudokuSolver(int sudoku[][], int row, int col) {
        // Base case
        if (row == 9) {
            return true;
        }
        // recursion
        int nextRow = row, nextCol = col + 1;
        if (col + 1 == 9) {
            nextRow = row + 1;
            nextCol = 0;
        }
        // condition for already set element
        if (sudoku[row][col] != 0) {
            return sudokuSolver(sudoku, nextRow, nextCol);
        }
        // conditon for add new element to place
        for (int digit = 1; digit <= 9; digit++) {
            if (isSafed(sudoku, row, col, digit)) {
                sudoku[row][col] = digit;
                if (sudokuSolver(sudoku, nextRow, nextCol)) { // solution exist
                    return true;
                }
                sudoku[row][col] = 0;
            }
        }
        return false;
    }

    public static boolean isSafed(int sudoku[][], int row, int col, int digit) {
        // Column
        for (int i = 0; i <= 8; i++) {
            if (sudoku[i][col] == digit) {
                return false;
            }
        }
        // Row
        for (int i = 0; i <= 8; i++) {
            if (sudoku[row][i] == digit) {
                return false;
            }
        }
        // Grid
        int sr = (row / 3) * 3;
        int sc = (col / 3) * 3;
        // 3x3 grid
        for (int i = sr; i < sr + 3; i++) {
            for (int j = sc; j < sc + 3; j++) {
                if (sudoku[i][j] == digit) {
                    return false;
                }
            }
        }
        return true;
    }

    public static void printSudoku(int sudoku[][]) {
        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                System.out.print(sudoku[i][j] + " ");
            }
            System.out.println();
        }
    }

    static int count = 0;

    public static void main(String[] args) {
        int arr[] = new int[5];
        changeArray(arr, 0, 1);
        printArray(arr);

        String str = "abc";
        System.out.println("Subset strings = ");
        findSubSet(str, "", 0);

        System.out.println("Permutation of string = ");
        permutation(str, "");

        System.out.println("N Queen Problem = ");
        int n = 4;
        char board[][] = new char[n][n];
        // initialize
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                board[i][j] = '.';
            }
        }
        nQueens(board, 0);
        System.out.println("Total no of ways to solve N Queen = " + count);

        if (isNQueenSolExist(board, 0)) {
            System.out.println("Solution is posible");
            printBoard(board);
        } else {
            System.out.println("Solution is not posible");
        }

        int N = 3, M = 3;
        System.out.println("Grid ways");
        System.out.println("Total ways = " + gridWays(0, 0, N, M));

        int sudoku[][] = {
                { 3, 0, 6, 5, 0, 8, 4, 0, 0 },
                { 5, 2, 0, 0, 0, 0, 0, 0, 0 },
                { 0, 8, 7, 0, 0, 0, 0, 3, 1 },
                { 0, 0, 3, 0, 1, 0, 0, 8, 0 },
                { 9, 0, 0, 8, 6, 3, 0, 0, 5 },
                { 0, 5, 0, 0, 9, 0, 6, 0, 0 },
                { 1, 3, 0, 0, 0, 0, 2, 5, 0 },
                { 0, 0, 0, 0, 0, 0, 0, 7, 4 },
                { 0, 0, 5, 2, 0, 6, 3, 0, 0 }
        };
        if (sudokuSolver(sudoku, 0, 0)) {
            System.out.println("Solution exist");
            printSudoku(sudoku);
        } else {
            System.out.println("Solution doesnot exist");
        }

    }
}