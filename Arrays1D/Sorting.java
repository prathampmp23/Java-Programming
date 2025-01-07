package Arrays1D;
import java.util.*;
public class Sorting {
    // The first three sorting algorithms has same code complexity of O(n2)

    // 1]Bubble sort Algorithm
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
    
    // 2]Selection sort Algorithm
    public static void SelectionSort(int arr[]) {
        for(int i=0; i<arr.length-1; i++){
            int current = i;
            for(int j=i+1; j<arr.length; j++){
                if(arr[current] > arr[j]){
                    current = j;
                }
            }
            int temp = arr[current];
            arr[current] = arr[i];
            arr[i] = temp;
        }
    }

    // 3]Insertion sort Algorithm
    public static void InsertionSort(int arr[]){
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

    // 4]Counting sort Algorithm
    public static void CountingSort(int arr[]){
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

    // This is the method to print Sorted Array
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
        SelectionSort(arr);
        InsertionSort(arr);
        CountingSort(arr);
        printArray(arr);
    }
}
