package RecursionPart2;

public class AllOccurrence {
    public static void FindallOccurrence(int arr[] , int key , int i){
        if(i == arr.length){
            return;
        }
        if(arr[i] == key){
            System.out.println(i+" ");
        }
        FindallOccurrence(arr, key, i+1);
    }
    public static void main(String args[]){
        int arr[ ] = {3, 2, 4, 5, 6, 2, 7, 2, 2};
        FindallOccurrence(arr,2,0);
        System.out.println();
    }
}
