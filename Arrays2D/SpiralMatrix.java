package Arrays2D;

public class SpiralMatrix {
    public static void PrintSpiral(int matrix[][]){
        int Startrow = 0;
        int Startcol = 0;
        int Endrow = matrix.length-1;
        int Endcol = matrix[0].length-1;
        while(Startrow<=Endrow && Startcol<=Endcol){
            //To print top row
            for(int j=Startcol; j<=Endcol; j++){
                System.out.print(matrix[Startrow][j]+" ");
            }
            //To print right column
            for(int i=Startrow+1; i<=Endrow; i++){
                System.out.print(matrix[i][Endcol]+" ");
            }
            //To print bottom row
            for(int j=Endcol-1; j>=Startcol; j--){
                if(Startrow == Endrow){
                    break;
                }
                System.out.print(matrix[Endrow][j]+" ");
            }
            //To print left row
            for(int i=Endrow-1; i>=Startrow+1; i--){
                if(Startcol == Endcol){
                    break;
                }
                System.out.print(matrix[i][Startcol]+" ");
            }
            Startrow++;
            Startcol++;
            Endrow--;
            Endcol--;
        }
        System.out.println();
    }
    public static void main(String args[]){
        int matrix[][] = {{1,2,3,4},{5,6,7,8},{9,10,11,12},{13,14,15,16}};
        PrintSpiral(matrix);
    }
}
