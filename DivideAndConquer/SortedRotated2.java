package DivideAndConquer;

import java.util.Scanner;

public class SortedRotated2 {
    public static boolean search(int[] nums, int target) {
        return search(nums, 0, nums.length - 1, target) != -1;
    }

    public static int search(int arr[], int si, int ei, int target) {
        // Base case
        if (si > ei)
            return -1;

        int mid = si + (ei - si) / 2;

        if (arr[mid] == target)
            return mid;

        // Handle duplicates
        if (arr[si] == arr[mid] && arr[mid] == arr[ei]) { 
            return search(arr, si + 1, ei - 1, target); // small change
        }

        // If left half is sorted
        if (arr[si] <= arr[mid]) {
            if (arr[si] <= target && target < arr[mid]) {
                return search(arr, si, mid - 1, target);
            } else {
                return search(arr, mid + 1, ei, target);
            }
        }
        // If right half is sorted
        else {
            if (arr[mid] < target && target <= arr[ei]) {
                return search(arr, mid + 1, ei, target);
            } else {
                return search(arr, si, mid - 1, target);
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
