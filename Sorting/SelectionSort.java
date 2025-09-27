package Sorting;
import java.util.Scanner;

public class SelectionSort {
    public static void selectionSort(int arr[]) {
        for(int i=0; i<arr.length-1; i++){
            int min = i;
            for(int j=i+1; j<arr.length; j++){
                if(arr[min] > arr[j]){
                    min = j;
                }
            }
            int temp = arr[min];
            arr[min] = arr[i];
            arr[i] = temp;
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
        selectionSort(arr);
        printArray(arr);
    }
}
