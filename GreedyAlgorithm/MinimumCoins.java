package GreedyAlgorithm;

import java.util.Arrays;

public class MinimumCoins {
    public static int minimumCoins(int[] coins, int amount) {
        Arrays.sort(coins);
        int minCoins = 0;
        for(int i= coins.length-1; i>=0; i--) {
            while (amount >= coins[i]) { 
                amount -= coins[i];
                minCoins++;
            }
        }

        return amount == 0 ? minCoins : -1;
    }

    public static void main(String[] args) {
        int coins[] = {1, 2, 5};
        int amount = 11;
        System.out.println(minimumCoins(coins, amount));
    }
}
