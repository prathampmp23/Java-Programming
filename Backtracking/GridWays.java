package Backtracking;

class GridWays {
    // Time complexity of O(2^n+m)

    public static int gridWays(int i , int j , int n ,int m) {
        //Base case
        if(i == n-1 && j == m-1) {
            //condition for last cell
            return 1;
        } else if(i == n || j == m) {
            //condition for boundary
            return 1;
        }

        int w1 = gridWays(i+1,j,n,m);   //Down turn
        int w2 = gridWays(i,j+1,n,m);   //right turn
        return w1 + w2;
    }
    public static void main(String args[]) {
        int n = 3, m = 3;
        System.out.println(gridWays(0,0,n,m));
    }
}