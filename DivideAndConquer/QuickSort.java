package DivideAndConquer;

import java.util.Scanner;

public class QuickSort {
    public static void printArray(int arr[]){
        for(int i=0; i<arr.length; i++){
            System.out.print(arr[i] +" ");
        } System.out.println();
    }
    public static void quickSort(int arr[] , int si , int ei){
        if(si >= ei){
            return;
        }
        int pivotindex = partition(arr, si, ei);
        quickSort(arr, si, pivotindex-1); // for left
        quickSort(arr, pivotindex+1, ei); // for right
    }
    public static int partition(int arr[] , int si , int ei){
        int pivot = arr[ei];
        int i = si-1;   // to make place in array

        for(int j=si; j<ei; j++){
            if(arr[j] <= pivot){
                i++;    //to make place to add value
                //swap
                int temp = arr[j];
                arr[j] = arr[i];
                arr[i] = temp;
            }
        }
        i++;
        int temp = pivot;
        arr[ei] = arr[i];  //**dont write pivot = arr[i]**//
        arr[i] = temp;
        return i;
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
        sc.close();
        quickSort(arr,0,arr.length-1);
        printArray(arr);
    }
}
