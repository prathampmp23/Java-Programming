package Arrays1D;

import java.util.Arrays;
import java.util.Collections;
import java.util.Scanner;

public class Inbuildsort {

    public static void Print(Integer arr[]) {
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + " ");
        }
        System.out.println();
    }

    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the size :");
        int size = sc.nextInt();
        System.out.println("Enter the Element :");
        Integer arr[] = new Integer[size];
        for (int i = 0; i < arr.length; i++) {
            arr[i] = sc.nextInt();
        }
        sc.close();

        // print sorted array in increasing order
        Arrays.sort(arr);

        // print sorted element upto start index to end index
        Arrays.sort(arr, 0, 3);

        // print Sorted array in reverse order
        Arrays.sort(arr, Collections.reverseOrder());
        Print(arr);
    }
}
