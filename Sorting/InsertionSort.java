package Sorting;
import java.util.*;

public class InsertionSort {
    public static void insertionSort(int arr[]){
        for(int i=1; i<arr.length; i++){
            int current = arr[i]; // to store it in the  temporary memory
            int previous = i-1;
            //find out correct position to insert
            while(previous >=0 && arr[previous] > current){
                arr[previous+1] = arr[previous];
                previous--;
            }
            // Do insertion
            arr[previous+1] = current;
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
        insertionSort(arr);
        printArray(arr);
    }
}
