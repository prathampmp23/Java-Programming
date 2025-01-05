package Arrays1D;

import java.util.*;

public class TrappedWater {
    public static int trappedWater(int height[]) {
        int n = height.length;

        // calculate left max array boundary
        // LeftMax = Math.max(height[i], leftMax[i-1]);
        int leftMax[] = new int[n];
        leftMax[0] = height[0];
        for (int i = 1; i < n; i++) {
            leftMax[i] = Math.max(height[i], leftMax[i - 1]);
        }

        // calculate right max array boundary
        // RightMax = Math.max(height[i], leftMax[i+1]);
        int Rightmax[] = new int[n];
        Rightmax[n - 1] = height[n - 1];
        for (int i = n - 2; i >= 0; i--) {
            Rightmax[i] = Math.max(height[i], Rightmax[i + 1]);
        }

        // loop
        int trappedwater = 0;
        for (int i = 0; i < n; i++) {
            // water level = min(leftMax,Rightmax)
            int waterLevel = Math.min(leftMax[i], Rightmax[i]);

            // Trapped Water += Water level - height[i]
            trappedwater += waterLevel - height[i];
        }
        return trappedwater;
    }

    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the size :");
        int size = sc.nextInt();
        System.out.println("Enter the element in an array:");
        int height[] = new int[size];
        for (int i = 0; i < height.length; i++) {
            height[i] = sc.nextInt();
        }
        sc.close();
        System.out.println("Total volume of trapped Water is :" + trappedWater(height));
    }
}
