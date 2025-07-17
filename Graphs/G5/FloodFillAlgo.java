package Graphs.G5;

public class FloodFillAlgo {

    // T.c = O(m*n)
    public static void helper(int image[][], int sr, int sc, int color, boolean visited[][], int orgCol) {

        if (sr < 0 || sc < 0 || sr >= image.length || sc >= image[0].length || visited[sr][sc] || image[sr][sc] != orgCol) {
            return;
        }

        visited[sr][sc] = true;
        image[sr][sc] = color;

        // left
        helper(image, sr, sc - 1, color, visited, orgCol);
        // right
        helper(image, sr, sc + 1, color, visited, orgCol);
        // up
        helper(image, sr - 1, sc, color, visited, orgCol);
        // down
        helper(image, sr + 1, sc, color, visited, orgCol);
    }

    public static int[][] floodFill(int image[][], int sr, int sc, int color) {
        boolean visited[][] = new boolean[image.length][image[0].length];
        helper(image, sr, sc, color, visited, image[sr][sc]);
        return image;
    }

    public static void main(String[] args) {
        int[][] image = {
                { 1, 1, 1 },
                { 1, 1, 0 },
                { 1, 0, 1 }
        };
        int sr = 1; // starting row
        int sc = 1; // starting column
        int newColor = 2; // new color to fill

        System.out.println("Before Flood Fill");
        for (int i = 0; i < image.length; i++) {
            for (int j = 0; j < image[0].length; j++) {
                System.out.print(image[i][j] + " ");
            }
            System.out.println();
        }

        System.out.println("After Flood Fill");
        floodFill(image, sr, sc, newColor);

        for (int i = 0; i < image.length; i++) {
            for (int j = 0; j < image[0].length; j++) {
                System.out.print(image[i][j] + " ");
            }
            System.out.println();
        }
    }
}
