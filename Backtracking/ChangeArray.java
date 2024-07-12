package Backtracking;

public class ChangeArray {
    public static void changearray(int arr[] , int index, int value){
        //Base case 
        if(index == arr.length){
            System.out.println("Array before backtracking");
            printArray(arr);
            return;
        }
        //Recursion
        arr[index] = value;
        changearray(arr,index+1,value+1);   //function call step
        arr[index] = arr[index] - 2;    //Backtracking step
    }
    public static void printArray(int arr[]){
        for(int i=0; i<arr.length; i++){
            System.out.print(arr[i]+" ");
        }
        System.out.println();
    }
    public static void main(String args[]){
        int arr[] = new int[5];
        changearray(arr,0,1);
        System.out.println("Array after backtracking ");
        printArray(arr);
    }
}
