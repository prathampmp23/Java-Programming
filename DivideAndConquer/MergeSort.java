package DivideAndConquer;

import java.util.Scanner;

public class MergeSort {
    public static void printaray(int arr[]){ 
        for(int i=0; i<arr.length; i++){
            System.out.print(arr[i]+" ");
        }
        System.out.println();
    }
    public static void mergeSort(int arr[] , int si , int ei){
        if(si >= ei){
            return;
        }
        int mid = si + (ei - si)/2;
        //left side
        mergeSort(arr, si, mid);
        //right side
        mergeSort(arr, mid+1, ei);

        merge(arr,si,mid,ei);
    }
    public static void merge(int arr[] , int si , int mid , int ei){
        int temp[] = new int[ei-si+1];
        int i = si;     //iteration for left part
        int j = mid+1;  //iteration for right part
        int k = 0;      //iteration for temp[] arr

        while(i <= mid && j <= ei){
            if(arr[i] < arr[j]){
                temp[k] = arr[i];
                i++;
            } else {
                temp[k] = arr[j];
                j++;
            }
            k++;
        }
        // Left part 
        while(i <= mid){
            temp[k++] = arr[i++];
        }
        // Right part 
        while(j <= ei){
            temp[k++] = arr[j++];
        }
        //copy temp array to original arr
        for(k=0, i=si; k<temp.length; k++, i++){
            arr[i] = temp[k];
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
        sc.close();
        mergeSort(arr,0,arr.length-1);
        printaray(arr);
    }
}
