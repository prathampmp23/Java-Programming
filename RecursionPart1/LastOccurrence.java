public class LastOccurrence {
    public static int lastOccurrence(int arr[], int key, int i){
        if(i == arr.length){
            return -1;
        }
        int isFound = lastOccurrence(arr,key,i+1);
        if(isFound == -1 && arr[i] == key){
            return i;
        }
        return isFound;
    }
    public static void main(String args[]){
        int arr[] = {1,4,6,8,5,3,8,9,5,6};
        System.out.println(lastOccurrence(arr,5,0));
    }
}
