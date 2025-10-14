package Z_Practice;

import java.util.ArrayList;
import java.util.List;

public class Recursion2 {

    public static int tilingProblem(int n) {
        // Base case
        if (n == 0 || n == 1) {
            return 1;
        }
        // // do work
        // // Vertical choice
        // int fNm1 = tilingProblem(n - 1);
        // // Horizontal choice
        // int fNm2 = tilingProblem(n - 2);
        // // Total possible ways
        // int totalWays = fNm1 + fNm2;
        // return totalWays;

        return tilingProblem(n - 1) + tilingProblem(n - 2);
    }

    public static void removeDuplicate(String str, int idx, StringBuilder newString, boolean map[]) {
        // Base case
        if (idx == str.length()) {
            System.out.println("After removing duplicates = " + newString);
            return;
        }
        char currChar = str.charAt(idx);
        if (map[currChar - 'a'] == true) {
            // duplicate
            removeDuplicate(str, idx + 1, newString, map);
        } else {
            // unique
            map[currChar - 'a'] = true;
            removeDuplicate(str, idx + 1, newString.append(currChar), map);
        }
    }

    public static int friendsPairing(int n) {
        // Base case
        if (n == 1 || n == 2) {
            return n;
        }
        // choice
        // Single
        int fNm1 = friendsPairing(n - 1);
        // Pair
        int fNm2 = friendsPairing(n - 2);
        int pairways = (n - 1) * fNm2;

        // Total ways
        int totalWays = fNm1 + pairways;
        return totalWays;

        // return friendsPairing(n - 1) + (n - 1) * friendsPairing(n - 2);
    }

    public static void printBinaryString(int n, int lastPlace, String str) {
        // Base case
        if (n == 0) {
            System.out.println(str);
            return;
        }
        
        // last Place 
        printBinaryString(n - 1, 0, str + "0");
        if (lastPlace == 0) {
            printBinaryString(n - 1, 1, str + "1");
        }
    }

    public static List<String> generateBinaryStrings(int n) {
        List<String> ans = new ArrayList<>();
        printBinaryString(n, 0, "" , ans);
        return ans;
        
    }
    public static void printBinaryString(int n, int lastPlace, String str, List<String> ans) {
        // Base case
        if (n == 0) {
            ans.add(str);
            return;
        }
        
        // last Place 
        printBinaryString(n - 1, 0, str + "0", ans);
        if (lastPlace == 0) {
            printBinaryString(n - 1, 1, str + "1", ans);
        }
    }

    public static void main(String[] args) {
        System.out.println("Tiling problem total ways = " + tilingProblem(3));
        String str = "appnnacollege";
        removeDuplicate(str, 0, new StringBuilder(""), new boolean[26]);
        System.out.println("Total friends paring ways = " + friendsPairing(3));
        printBinaryString(3, 0, "");

        List<String> ans = generateBinaryStrings(3);
        System.out.println(ans);
    }
}
