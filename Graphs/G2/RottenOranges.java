package Graphs.G2;

import java.util.LinkedList;
import java.util.Queue;

public class RottenOranges {
    static class Pair {
        int row;
        int col;
        int t;

        public Pair(int row, int col, int t) {
            this.row = row;
            this.col = col;
            this.t = t;
        }
    }

    public static int orangesRotting(int[][] grid) {
        int n = grid.length;
        int m = grid[0].length;

        Queue<Pair> q = new LinkedList<>();

        int visited[][] = new int[n][m];
        int cntFresh = 0;

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (grid[i][j] == 2) {
                    q.add(new Pair(i, j, 0));
                    visited[i][j] = 2;
                }
                if (grid[i][j] == 1)
                    cntFresh++;
                else {
                    visited[i][j] = 0;
                }
            }
        }

        int tm = 0;
        int adjRow[] = { -1, 0, +1, 0 };
        int adjCol[] = { 0, +1, 0, -1 };
        int cnt = 0;
        while (!q.isEmpty()) {
            int r = q.peek().row;
            int c = q.peek().col;
            int t = q.peek().t;
            tm = Math.max(tm, t);
            q.poll();

            for (int i = 0; i < 4; i++) {
                int nRow = r + adjRow[i];
                int nCol = c + adjCol[i];
                if (nRow >= 0 && nRow < n && nCol >= 0 && nCol < m
                        && visited[nRow][nCol] == 0 && grid[nRow][nCol] == 1) {
                    q.add(new Pair(nRow, nCol, t + 1));
                    visited[nRow][nCol] = 2;
                    cnt++;
                }
            }
        }
        if (cnt != cntFresh)
            return -1;
        return tm; // min time
    }

    public static void main(String[] args) {

        /*
         * You are given an m x n grid where each cell can have one of three values:
         * 0 representing an empty cell,
         * 1 representing a fresh orange, or
         * 2 representing a rotten orange.
         * Every minute, any fresh orange that is 4-directionally adjacent to a rotten
         * orange becomes rotten.
         * Return the minimum number of minutes that must elapse until no cell has a
         * fresh orange. If this is impossible, return -1.
         */
        int grid[][] = { { 2, 1, 1 }, { 1, 1, 0 }, { 0, 1, 1 } };
        System.out.println(orangesRotting(grid)); // time = 4

        // Input: grid = [[2,1,1],[0,1,1],[1,0,1]]
        // Output: -1
    }
}
