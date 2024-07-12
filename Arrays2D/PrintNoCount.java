package Arrays2D;

public class PrintNoCount {
   
    public static void main(String args[]){
        int arr[][] = { {4,7,8},{8,8,7},{4,6,7} };
        int count = 0;
        int key = 7;
            for(int i = 0; i < arr.length; i++){
                for(int j = 0; j < arr[0].length; j++){
                    if(arr[i][j] % key == 0){
                        count++;
                    }
                }
            }
            System.out.println("Count of 7 is :"+ count);
    }
}
