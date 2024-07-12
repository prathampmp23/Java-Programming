package Backtracking;

import java.util.Scanner;

//Time complexity = O(n!)
public class QueensOneSolution {
    public static boolean nQueens(char board[][], int row ) {
        //base case
        if(row == board.length) {
            return true;
        }
        //column step
        for(int j=0; j<board.length; j++) {
            if(issafe(board,row,j)) {
                board[row][j] = 'Q';    //placing queen at place
                if(nQueens(board,row+1)) {
                    return true;
                }   
                board[row][j] = 'x';    //Backtracking step
            }
        }
        return false;
    }
    public static boolean issafe(char board[][], int row, int col) {
        //for vertically up
        for(int i=row-1; i>=0; i--) {
            if(board[i][col] == 'Q') {
                return false;
            }
        }
        //for diagonaly left up
        for(int i=row-1, j=col-1; i>=0 && j>=0; i--,j--) {
            if(board[i][j] == 'Q') {
                return false;
            }
        }
        //for diagonaly right up
        for(int i=row-1, j=col+1; i>=0 && j<board.length; i--,j++) {
            if(board[i][j] == 'Q') {
                return false;
            }
        }
        return true;
    }
    public static void printboard(char board[][]) {
        System.out.println("------chess board------");
        for(int i=0; i<board.length; i++) {
            for(int j=0; j<board.length; j++) {
                System.out.print(board[i][j]+" ");
            }
            System.out.println();
        }
    }
    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        sc.close();
        char board[][] = new char[n][n];
        //Initialize
        for(int i=0; i<n; i++){
            for(int j=0; j<n; j++){
                board[i][j] = 'x';
            }
        }
        if(nQueens(board,0)) {
            System.out.println("Solution is Possible");
            printboard(board);
        } else {
            System.out.println("Solution is Possible");
        }
        
    }
}
