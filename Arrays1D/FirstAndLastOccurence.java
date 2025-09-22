package Arrays1D;

public class FirstAndLastOccurence {

    public static int[] searchRange(int[] nums, int target) {
        int ans[] = new int[2];
        ans[0] = firstOccurrence(nums, target, 0);
        ans[1] = lastOccurrence(nums, target, 0);
        return ans;
    }

    public static int firstOccurrence(int arr[], int key , int i){
        if(i == arr.length){
            return -1;
        }
        if(arr[i] == key){
            return i;
        }
        return firstOccurrence(arr,key,i+1);
    }
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

    public static void main(String[] args) {
        int arr[] = { 5, 6, 8, 9, 6, 5, 5, 6 };
        int x = 6;
        int ans[] = searchRange(arr, x);
        System.out.println("First Occurence = " + ans[0]);
        System.out.println("Last Occurence = " + ans[1]);
    }
}