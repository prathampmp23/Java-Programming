package Graphs.G2;

import java.util.LinkedList;
import java.util.Queue;

public class NoOfIslands {

    static class Pair {
        int row;
        int col;

        public Pair(int row, int col) {
            this.row = row;
            this.col = col;
        }
    }

    public static int countDistinctIslands(int[][] grid) {
        int n = grid.length;
        int m = grid[0].length;
        int cnt = 0;

        int vist[][] = new int[n][m];

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (vist[i][j] == 0 && grid[i][j] == 1) {
                    bfs(i, j, grid, vist);
                    cnt++;
                }
            }
        }
        return cnt;
    }

    public static void bfs(int row, int col, int grid[][], int vist[][]) {
        vist[row][col] = 1;
        Queue<Pair> q = new LinkedList<Pair>();

        int n = grid.length;
        int m = grid[0].length;

        q.add(new Pair(row, col));

        while (!q.isEmpty()) {
            int r = q.peek().row;
            int c = q.peek().col;
            q.remove();

            for (int i = -1; i <= 1; i++) {
                for (int j = -1; j <= 1; j++) {
                    int nRow = r + i;
                    int nCol = c + j;
                    if (nRow >= 0 && nRow < n && nCol >= 0 && nCol < m 
                        && grid[nRow][nCol] == 1 && vist[nRow][nCol] == 0) {

                        vist[nRow][nCol] = 1;
                        q.add(new Pair(nRow, nCol));
                    }
                }
            }
        }
    }

    public static void main(String[] args) {
        int grid1[][] = {{1, 1, 0, 0, 0},
                        {1, 1, 0, 0, 0},
                        {0, 0, 0, 1, 1},
                        {0, 0, 0, 1, 1}};
        int grid2[][] = {{1, 1, 0, 1, 1},
                        {1, 0, 0, 0, 0},
                        {0, 0, 0, 0, 1},
                        {1, 1, 0, 1, 1}};

        System.out.println(countDistinctIslands(grid1));
        System.out.println(countDistinctIslands(grid2));
    }
}