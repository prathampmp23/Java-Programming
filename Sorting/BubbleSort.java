package Sorting;

import java.util.Scanner;

public class BubbleSort {
    public static void BubblesSort(int arr[]) {
        for(int turn=0; turn<arr.length-1; turn++){ //turn<=arr.length-2;
            boolean Swaped = false;
            for(int j=0; j<arr.length-1-turn; j++){ //j<=arr.length-2-turn;

                if(arr[j] > arr[j+1]){        //this print array in increasing order
              //if(arr[j] < arr[j+1]){        //this print array in decreasing order
                    int temp = arr[j];
                    arr[j] = arr[j+1];
                    arr[j+1] = temp;
                    Swaped = true;
                }
            }
            if(Swaped == true){
                break;
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
        BubblesSort(arr);
        printArray(arr);
    }
}
