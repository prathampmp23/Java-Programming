package Pattern;

import java.util.Scanner;

public class PrathamName {
    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        // int n = sc.nextInt();
        // int m = sc.nextInt();
        int n = 5;
        int m = 8;
        sc.close();

        // this is to print P

        System.out.println();
        System.out.println();

        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= m; j++) {
                if (i == 1 || j == 1 || i == n || j == m) {
                    System.out.print("* ");
                } else {
                    System.out.print("  ");
                }
            }
            System.out.println();
        }
        for (int i = 1; i < n; i++) {
            System.out.println("*");
        }
        System.out.println();

        // this is to print R

        int st = n;
        int sp = n - 2;
        int line = 1;
        while (line <= n + 2) {
            // to print star
            if (line == 1 || line == n - 1) {
                for (int i = 0; i < st; i++) {
                    System.out.print("* ");
                }
            } else {
                // to print one star
                System.out.print("*  ");
                // to print spaces
                for (int j = 0; j < sp; j++) {
                    System.out.print("  ");
                }
                // to print one star
                System.out.print("*  ");
            }
            line++;
            System.out.println();

        }

        System.out.println();

        // this is to print A

        // int p = 5;
        // int str = p;
        // int spa = p - 2;
        // int lineof = 1;
        // while (lineof <= p) {
        // // to print star
        // if (lineof == 1 || lineof == p - 1) {
        // for (int i = 0; i < str; i++) {
        // System.out.print("*");
        // }
        // } else {
        // // to print one star
        // System.out.print("*");
        // // to print spaces
        // for (int j = 0; j < spa; j++) {
        // System.out.print(" ");
        // }
        // // to print one star
        // System.out.print("*");
        // }
        // lineof++;
        // System.out.println();
        // }

        int height = 7; // Height of the letter

        for (int i = 0; i < height; i++) {
            for (int j = 0; j <= height; j++) {
                // Print '*' for the edges and the middle horizontal line
                if ((j == 0 || j == height) && i != 0 || // Side edges, except the top point
                        i == 0 && j > 0 && j < height || // Top horizontal line
                        i == height / 2) { // Middle horizontal line
                    System.out.print("*");
                } else {
                    System.out.print(" ");
                }
            }
            System.out.println();
        }
        System.out.println();

        // this is to print T
        for (int i = 1; i <= n; i++) {
            System.out.print("* ");
        }
        System.out.println();
        for (int j = 1; j <= n; j++) {
            System.out.print("    " + "*" + "     ");
            System.out.println();
        }
        System.out.println();

        // to print H
        int star = 4;
        int space = n - 2;
        int newline = 1;
        while (newline <= n) {
            if (newline == 3) {
                for (int i = 0; i <= star; i++) {
                    System.out.print("* ");
                }
            } else {
                // to print one star
                System.out.print("* ");
                // to print space
                for (int j = 0; j < space; j++) {
                    System.out.print("  ");
                }
                // to print one star
                System.out.print("* ");

            }
            newline++;

            System.out.println();
        }

        System.out.println();

        // this is to print A
        for (int i = 0; i < height; i++) {
            for (int j = 0; j <= height; j++) {
                // Print '*' for the edges and the middle horizontal line
                if ((j == 0 || j == height) && i != 0 || // Side edges, except the top point
                        i == 0 && j > 0 && j < height || // Top horizontal line
                        i == height / 2) { // Middle horizontal line
                    System.out.print("*");
                } else {
                    System.out.print(" ");
                }
            }
            System.out.println();
        }
        System.out.println();

        // to print M
        int y = n - 2;
        int z = 4;
        int Line = 1;
        while (Line <= z) {
            // to print star
            if (Line == 1 || Line == 3 || Line == 4) {
                // to print one star
                System.out.print("*");
                // to print spaces
                for (int j = 0; j < y; j++) {
                    System.out.print("  ");
                }
                // to print one star
                System.out.print("*");
            } else {
                System.out.println("* * " + " " + "* * ");
                System.out.print("*" + "  " + "*" + "   " + "*");
            }
            Line++;
            System.out.println();
        }
    }
}