package Backtracking;
//** flood-fill Algorithm **//
    //Time complexity = 4^n

public class RatinMaze {
    public static void findAllPaths(int i, int j, int N, int matrix[][] , boolean visited[][], String psf) {
        //or if only one condition is true then use || (OR)
        if(i<0 || j<0 || i>=N || j>=N) {
            return;
        }
        //or if only one condition is true then use || (OR)
        if(matrix[i][j] == 0 || visited[i][j] == true){
            return;
        }
        //If both condition is required to be true then use && (AND)
        if(i==N-1 && j==N-1) {
            System.out.println("Destination is reached " + psf);
            return;
        }
        visited[i][j] = true;   //to mark the path is visited

        findAllPaths(i-1, j, N, matrix, visited, psf + "U");  // up
        findAllPaths(i+1, j, N, matrix, visited, psf + "D");  // down
        findAllPaths(i, j-1, N, matrix, visited, psf + "L");  // left
        findAllPaths(i, j+1, N, matrix, visited, psf + "R");  // right

        //This allow to travel through same cell as some other path
        visited[i][j] = false;  //to mark the path is unvisited
    }
    public static void main(String args[]) {
        int matrix[][] = {{1,1,1,1},{0,1,0,1},{1,1,1,1},{1,0,1,1}};
        int N = matrix.length;
        boolean visited[][] = new boolean[N][N];
        findAllPaths(0,0,N,matrix,visited,"");
        //psf = path so far
    }
}
