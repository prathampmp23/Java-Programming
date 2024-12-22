// Source code is decompiled from a .class file using FernFlower decompiler.
import java.util.Scanner;

public class Knapsack {
   public Knapsack() {
   }

   static int knapsack(int var0, int[] var1, int[] var2, int var3) {
      int[][] var4 = new int[var3 + 1][var0 + 1];

      for(int var5 = 0; var5 <= var3; ++var5) {
         for(int var6 = 0; var6 <= var0; ++var6) {
            if (var5 != 0 && var6 != 0) {
               if (var1[var5 - 1] <= var6) {
                  var4[var5][var6] = Math.max(var2[var5 - 1] + var4[var5 - 1][var6 - var1[var5 - 1]], var4[var5 - 1][var6]);
               } else {
                  var4[var5][var6] = var4[var5 - 1][var6];
               }
            } else {
               var4[var5][var6] = 0;
            }
         }
      }

      return var4[var3][var0];
   }

   public static void main(String[] var0) {
      Scanner var1 = new Scanner(System.in);
      System.out.print("Enter the number of items: ");
      int var2 = var1.nextInt();
      int[] var3 = new int[var2];
      int[] var4 = new int[var2];
      System.out.println("Enter the values of the items: ");

      int var5;
      for(var5 = 0; var5 < var2; ++var5) {
         var3[var5] = var1.nextInt();
      }

      System.out.println("Enter the weights of the items: ");

      for(var5 = 0; var5 < var2; ++var5) {
         var4[var5] = var1.nextInt();
      }

      System.out.print("Enter the capacity of the knapsack: ");
      var5 = var1.nextInt();
      int var6 = knapsack(var5, var4, var3, var2);
      System.out.println("The maximum profit is: " + var6);
      var1.close();
   }
}
