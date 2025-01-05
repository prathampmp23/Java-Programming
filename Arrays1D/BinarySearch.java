package Arrays1D;

import java.util.Scanner;
import java.util.Arrays;

public class BinarySearch {

    public static int Binarysearch(int num[], int key) {
        Arrays.sort(num);
        int start = 0;
        int end = num.length - 1;
        while (start <= end) {
            int mid = (start + end) / 2;
            // If found
            if (num[mid] == key) {
                return mid;
            }
            if (num[mid] < key) {
                // go to right part
                // mid -> end
                start = mid + 1;
            } else {
                // go to left part
                // start -> mid
                end = mid - 1;
            }
        }
        return -1;
    }

    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the size ");
        int size = sc.nextInt();
        int num[] = new int[size];
        for (int i = 0; i < num.length; i++) {
            System.out.println("Enter element at index : " + i);
            num[i] = sc.nextInt();
        }
        System.out.println("Enter the number to find :");
        int key = sc.nextInt();
        sc.close();
        System.out.println("Number at index : " + Binarysearch(num, key));

    }
}
