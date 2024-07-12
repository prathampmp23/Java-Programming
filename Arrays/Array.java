package Arrays;

import java.util.*;

public class Array {
    public static boolean Twicevalue(int num[]) {
        for (int i = 0; i < num.length - 1; i++) {
            for (int j = i + 1; j < num.length; j++) {
                if (num[i] == num[j]) {
                    return true;
                }
            }
        }
        return false;
    }

    public static int Profit(int num[]) {
        int buyPrice = Integer.MAX_VALUE;
        // Intege.Max_VALUE is to find minimum value
        int maxProfit = 0;
        for (int i = 0; i < num.length; i++) {
            if (buyPrice < num[i]) {
                int profit = num[i] - buyPrice;
                maxProfit = Math.max(maxProfit, profit);
            } else {
                buyPrice = num[i];
            }
        }
        return maxProfit;
    }

    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the Size of Array :");
        int size = sc.nextInt();
        System.out.println("Enter the element in Array :");
        int num[] = new int[size];
        for (int i = 0; i < num.length; i++) {
            num[i] = sc.nextInt();
        }
        sc.close();
        System.out.println(Twicevalue(num));
    }
}
