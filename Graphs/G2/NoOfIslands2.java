// package Graphs.G2;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;

public class NoOfIslands2 {

    static class Pair {
        int row, col;

        Pair(int r, int c) {
            row = r;
            col = c;
        }
    }

    public static int countDistinctIslands(int[][] grid) {
        int n = grid.length, m = grid[0].length;
        int[][] vist = new int[n][m];
        HashSet<String> set = new HashSet<>();

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (grid[i][j] == 1 && vist[i][j] == 0) {
                    String shape = bfs(i, j, grid, vist);
                    set.add(shape);
                }
            }
        }
        return set.size();
    }

    public static String bfs(int row, int col, int[][] grid, int[][] vist) {
        int n = grid.length, m = grid[0].length;
        Queue<Pair> q = new LinkedList<>();
        StringBuilder shape = new StringBuilder();

        q.add(new Pair(row, col));
        vist[row][col] = 1;

        while (!q.isEmpty()) {
            int r = q.peek().row;
            int c = q.peek().col;
            q.remove();
            shape.append((r - row) + "," + (c - col) + ";");

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
        // System.out.println(shape.toString());
        return shape.toString();
    }

    public static void main(String[] args) {
        int grid1[][] = { { 1, 1, 0, 0, 0 },
                { 1, 1, 0, 0, 0 },
                { 0, 0, 0, 1, 1 },
                { 0, 0, 0, 1, 1 } };
        int grid2[][] = { { 1, 1, 0, 1, 1 },
                { 1, 0, 0, 0, 0 },
                { 0, 0, 0, 0, 1 },
                { 1, 1, 0, 1, 1 } };

        System.out.println(countDistinctIslands(grid1));
        System.out.println(countDistinctIslands(grid2));
    }
}