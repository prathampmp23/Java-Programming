package Graphs.G2;

import java.util.LinkedList;
import java.util.Queue;

public class SurroundedRegion {

    public void solve(char[][] board) {
        int n = board.length;
        int m = board[0].length;

        Queue<int[]> q = new LinkedList<>();

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (board[i][j] == 'O' && (i == 0 || i == n - 1 || j == 0 || j == m - 1)) {
                    q.add(new int[] { i, j });
                    board[i][j] = 'T';
                }
            }
        }

        int[][] dirs = { { 1, 0 }, { -1, 0 }, { 0, 1 }, { 0, -1 } };

        // BFS
        while (!q.isEmpty()) {
            int cell[] = q.poll();
            int r = cell[0];
            int c = cell[1];

            for (int[] d : dirs) {
                int nr = r + d[0];
                int nc = c + d[1];

                if (nr >= 0 && nr < n && nc >= 0 && nc < m && board[nr][nc] == 'O') {
                    board[nr][nc] = 'T';
                    q.offer(new int[] { nr, nc });
                }
            }
        }
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (board[i][j] == 'O') {
                    board[i][j] = 'X';
                } else if (board[i][j] == 'T') {
                    board[i][j] = 'O';
                }
            }
        }
    }

    /*
     * You are given an m x n matrix board containing letters 'X' and 'O', capture
     * regions that are surrounded:
     * Connect: A cell is connected to adjacent cells horizontally or vertically.
     * 
     * To capture a surrounded region, replace all 'O's with 'X's in-place within
     * the original board. You do not need to return anything.
     * 
     * Input: board =
     * [["X","X","X","X"],
     * ["X","O","O","X"],
     * ["X","X","O","X"],
     * ["X","O","X","X"]]
     * 
     * Output:
     * [["X","X","X","X"],
     * ["X","X","X","X"],
     * ["X","X","X","X"],
     * ["X","O","X","X"]]
     */
}