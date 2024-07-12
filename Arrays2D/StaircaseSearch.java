package Arrays2D;

public class StaircaseSearch {
    // Staircase Search
    // it has code complexity of O(n+m)
    public static boolean SearchinSortedMatrix(int matrix[][] , int key){
        int row = 0, col = matrix[0].length-1;

        while(row < matrix.length && col >= 0){
            if(matrix[row][col] == key){
                System.out.println("Key is found at index :"+"("+row+","+col+")");
                return true;
            } else if(key < matrix[row][col]){
                // to move in left in row
                col--;
            } else {
                // to move bottom side
                row++;
            }
        }
        System.out.println("key is not found :");
        return false;
    }
    public static void main(String args[]){
        int matrix[][] = {{10,20,30,40},{15,25,35,45},{27,29,37,48},{32,33,39,50}};
        int key = 33;
        SearchinSortedMatrix(matrix,key);
    }
}