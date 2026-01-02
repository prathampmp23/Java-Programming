package Z_Practice;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class AdjacencyList {
    public static void main(String[] args) {

        // input
        /*
        5
        0 1
        1 2
        2 3
        3 4
        0 4 
        */
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();

        List<List<Integer>> adj = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            adj.add(new ArrayList<>());
        }

        // Number of edges is unknown; read until input ends
        while (sc.hasNextInt()) {
            int v = sc.nextInt();
            int e = sc.nextInt();
            adj.get(v).add(e);
            adj.get(e).add(v);
        }

        for (int i = 0; i < n; i++) {
            System.out.print("vertex " + i + ": ");
            for (int neighbor : adj.get(i)) {
                System.out.print(neighbor + " ");
            }
            System.out.println();
        }
        sc.close();
    }
}
