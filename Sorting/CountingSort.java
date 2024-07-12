package Sorting;
import java.util.*;

public class CountingSort {
    public static void countingSort(int arr[]){
        int largest = Integer.MIN_VALUE;
        for(int i=0; i<arr.length; i++){
            largest = Math.max(largest, arr[i]);
        }
        //finding frequency
        int count[] = new int[largest+1];
        for(int i=0; i<arr.length; i++){
            count[arr[i]]++;
        }
        //sorting
        int j=0;
        for(int i=0; i<count.length; i++){
            while(count[i] > 0){
            arr[j] = i;
            j++;
            count[i]--;
            }
        }
    }
    public static void printArray(int arr[]) {
        for(int i=0; i<arr.length; i++){
            System.out.print(arr[i]+" ");
        }
        System.out.println();
    }

    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the Size of array :");
        int size = sc.nextInt();
        System.out.println("Enter the Element in array :");
        int arr[] = new int[size];
        for(int i=0; i<arr.length; i++){ 
            arr[i] = sc.nextInt();
        }
        sc.close();
        countingSort(arr);
        printArray(arr);
    }
}
