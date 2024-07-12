package Arrays2D;

public class SumRow {
    public static void main(String args[]){
        int arr[][] =  {{1,4,9},{11,4,3},{2,2,3}};
        int sum = 0;
        
        // for(int i=1; i<arr.length-1; i++){
        //     for(int j=0; j<arr[0].length; j++){
        //         sum+= arr[i][j];
        //     }
        // }

        // we can directly calculate sum of 2nd row

        for(int j=0; j<arr[0].length; j++){
            // row = 1  or col = 0 to 2
            sum+= arr[1][j];
        }
        System.out.println("sum is :"+ sum);
    }
}
