public class CheckSortArray {
    public static boolean isSortedArray(int arr[] ,int i){
        //if length is only 1
        if( i == arr.length-1){
            return true;
        }
        //check whether it is sorted or not
        if(arr[i] > arr[i+1]){
            return false;
        }
        return isSortedArray(arr, i+1);
    }
    public static void main(String args[]){
        int arr[] = {1,2,3,4,5};
        int i = 0;
        System.out.println(isSortedArray(arr,i));;
    }
}
