package GreedyAlgorithm;

import java.util.Arrays;
import java.util.Collections;

public class ChocolaProblem {
    public static void main(String[] args) {
        // n = 4, m = 6;
        Integer horizontalCost[] = { 2, 1, 3, 1, 4 }; // m-1
        Integer verticalCost[] = { 4, 1, 2 }; // n-1

        Arrays.sort(verticalCost, Collections.reverseOrder());
        Arrays.sort(horizontalCost, Collections.reverseOrder());

        int Hcut = 0, Vcut = 0;
        int HPiece = 1, VPiece = 1;
        int cost = 0;

        while (Hcut < horizontalCost.length && Vcut < verticalCost.length) {
            // vertical cost < horzontal cost
            if (verticalCost[Vcut] <= horizontalCost[Hcut]) {
                // Make horizontal cut
                cost += (horizontalCost[Hcut] * VPiece);
                HPiece++;
                Hcut++;
            } else {
                // make vertical cut
                cost += (verticalCost[Vcut] * HPiece);
                VPiece++;
                Vcut++;
            }
        }
        // for remaining cuts
        while (Hcut < horizontalCost.length) {
            cost += (horizontalCost[Hcut] * VPiece);
            HPiece++;
            Hcut++;
        }
        while (Vcut < verticalCost.length) {
            cost += (verticalCost[Vcut] * HPiece);
            VPiece++;
            Vcut++;
        }

        System.out.println("Min cost of cuts = " + cost);
    }
}
