package Backtracking;

public class SudokuVisualization {

    // --- visualization controls ---
    static final boolean VISUALIZE = true; 
    static final int DELAY_MS = 50; 
    static boolean firstPaint = true;

    public static boolean sudokuSolver(int[][] sudoku, int row, int col) {
        // base case
        if (row == 9) {
            paint(sudoku, -1, -1, "SOLVED");
            return true;
        }

        // next cell
        int nextRow = row, nextCol = col + 1;
        if (col + 1 == 9) {
            nextRow = row + 1;
            nextCol = 0;
        }

        // skip filled cells
        if (sudoku[row][col] != 0) {
            return sudokuSolver(sudoku, nextRow, nextCol);
        }

        for (int digit = 1; digit <= 9; digit++) {
            if (isSafe(sudoku, row, col, digit)) {
                // place
                sudoku[row][col] = digit;
                paint(sudoku, row, col, "place " + digit);

                if (sudokuSolver(sudoku, nextRow, nextCol))
                    return true;

                // backtrack
                sudoku[row][col] = 0;
                paint(sudoku, row, col, "backtrack");
            }
        }
        return false; // trigger backtrack
    }

    public static boolean isSafe(int[][] s, int row, int col, int d) {
        // col
        for (int i = 0; i < 9; i++)
            if (s[i][col] == d)
                return false;
        // row
        for (int j = 0; j < 9; j++)
            if (s[row][j] == d)
                return false;
        // 3x3 box
        int sr = (row / 3) * 3, sc = (col / 3) * 3;
        for (int i = sr; i < sr + 3; i++)
            for (int j = sc; j < sc + 3; j++)
                if (s[i][j] == d)
                    return false;
        return true;
    }

    // Pretty painter that redraws in-place
    static void paint(int[][] s, int highlightR, int highlightC, String status) {
        if (!VISUALIZE)
            return;
        try {
            // Clear screen on first paint, later just move cursor to top-left
            if (firstPaint) {
                System.out.print("\u001B[2J"); // clear screen
                firstPaint = false;
            }
            System.out.print("\u001B[H"); // move cursor to home (row 1, col 1)

            StringBuilder sb = new StringBuilder();
            sb.append("Sudoku backtracking ").append(status == null ? "" : "(" + status + ")").append('\n');
            sb.append("+-------+-------+-------+\n");
            for (int i = 0; i < 9; i++) {
                sb.append("| ");
                for (int j = 0; j < 9; j++) {
                    String cell = s[i][j] == 0 ? "." : String.valueOf(s[i][j]);
                    // lightly highlight the current cell with inverse video
                    if (i == highlightR && j == highlightC) {
                        sb.append("\u001B[7m").append(cell).append("\u001B[0m");
                    } else {
                        sb.append(cell);
                    }
                    sb.append(' ');
                    if ((j + 1) % 3 == 0)
                        sb.append("| ");
                }
                sb.append('\n');
                if ((i + 1) % 3 == 0)
                    sb.append("+-------+-------+-------+\n");
            }
            System.out.print(sb.toString());
            System.out.flush();
            Thread.sleep(DELAY_MS);
        } catch (InterruptedException ignored) {
        }
    }

    public static void main(String[] args) {
        int[][] sudoku = {
                { 0, 0, 8, 0, 0, 0, 0, 0, 0 },
                { 4, 9, 0, 1, 5, 7, 0, 0, 2 },
                { 0, 0, 3, 0, 0, 4, 1, 9, 0 },
                { 1, 8, 5, 0, 6, 0, 0, 2, 0 },
                { 0, 0, 0, 0, 2, 0, 0, 6, 0 },
                { 9, 6, 0, 4, 0, 5, 3, 0, 0 },
                { 0, 3, 0, 0, 7, 2, 0, 0, 4 },
                { 0, 4, 9, 0, 3, 0, 0, 5, 7 },
                { 8, 2, 7, 0, 0, 9, 0, 1, 3 }
        };

        boolean ok = sudokuSolver(sudoku, 0, 0);
        System.out.print("\n" + (ok ? "Solution exists yes" : "No solution ") + "\n");
    }
}
