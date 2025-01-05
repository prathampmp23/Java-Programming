package Arrays1D;

import java.util.*;

public class LargestArray {
    public static int largest(int num[]) {
        int LargeNo = Integer.MIN_VALUE; // -Infinity
        for (int i = 0; i < num.length; i++) {
            if (LargeNo < num[i]) {
                LargeNo = num[i];
            }
        }
        return LargeNo;
    }

    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the size :");
        int size = sc.nextInt();
        System.out.println("Enter the element :");
        int num[] = new int[size];
        for (int i = 0; i < num.length; i++) {
            num[i] = sc.nextInt();
        }
        sc.close();
        System.out.println("Largest number in an Array is :" + largest(num));
    }
}
