package Backtracking;
class Knight2 {
    public static void knightPath(int i,int j, int N, int matrix[][], int moveNum) {
        if(i<0 || j<0 || i>=N || j>=N){
            return;
        }
        if(matrix[i][j] != 0){ // we have been (visited) at this point before
            return;
        }
        matrix[i][j] = moveNum;

        //To print matrix
        if(moveNum == N*N - 1){
            for(int x=0; x<N; x++){
                for(int y=0; y<N; y++){
                    System.out.print(matrix[x][y]+" ");
                }
                System.out.println();
            }
            return;
        }

        knightPath(i+2,j+1,N,matrix,moveNum + 1);
        knightPath(i+1,j+2,N,matrix,moveNum + 1);
        knightPath(i-1,j+2,N,matrix,moveNum + 1);
        knightPath(i-2,j+1,N,matrix,moveNum + 1);
        knightPath(i-2,j-1,N,matrix,moveNum + 1);
        knightPath(i-1,j-2,N,matrix,moveNum + 1);
        knightPath(i+1,j-2,N,matrix,moveNum + 1);
        knightPath(i+2,j-1,N,matrix,moveNum + 1);

        matrix[i][j] = 0;
        return;
    }
    public static void main(String args[]) {
    // int matrix[][] = new int[8][8];
    knightPath(0,0,8,new int[8][8],0);
}
}
