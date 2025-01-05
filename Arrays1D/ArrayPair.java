package Arrays1D;

import java.util.*;

public class ArrayPair {
    public static void Pair(int num[]) {
        for (int i = 0; i < num.length; i++) {
            int current = num[i];
            for (int j = i + 1; j < num.length; j++) {
                System.out.print("(" + current + "," + num[j] + ")");
            }
            System.out.println();
        }
    }

    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        int size = sc.nextInt();
        int num[] = new int[size];
        for (int i = 0; i < num.length; i++) {
            num[i] = sc.nextInt();
        }
        sc.close();
        Pair(num);

    }
}
