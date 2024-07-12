package DivideAndConquer;

import java.util.Scanner;

public class SortedRotated {
    public static int search(int arr[] , int si, int ei, int target){
        //Base case
        if(si > ei){
            return -1;
        }
        //Find mid
        int mid = si + (ei-si)/2;

        //If target is found
        if(arr[mid] == target){
            return mid;
        } 
        //mid Line1
        if(arr[si] <= arr[mid]) {
                //case 1 for left
            if(arr[si] <= target && target <= arr[mid] ){
                return search(arr, si, mid-1, target);
            } else {
                //case 2 for right
                return search(arr, mid+1, ei, target);
            }
        } 
        
        //mid Line2
        else {
            // case 3 for right
            if(arr[mid] <= target && target <= arr[ei]){
                return search(arr, mid+1, ei, target);
            } else {
                //case 4 for left
                return search(arr, si, mid-1, target);
            }
        }
    }
    public static void main(String args[]){
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the size :");
        int size = sc.nextInt();
        System.out.println("Enter the Element :");
        int arr[] = new int[size];
        for(int i=0; i<arr.length; i++) {
            arr[i] = sc.nextInt();
        }
        System.out.println("Enter the value to find :");
        int target = sc.nextInt();
        sc.close();
        int index = search(arr,0,arr.length-1,target);
        System.out.println("Value is found at index :"+index);
    }
}
