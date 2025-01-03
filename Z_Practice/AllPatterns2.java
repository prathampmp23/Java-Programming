package Z_Practice;
import java.util.*;

public class AllPatterns2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the number :");
        int n = sc.nextInt();
        System.out.println("pyramid 1");
        for (int line = 1; line <= n; line++) {
            for (int star = 1; star <= line; star++) {
                System.out.print("*" + " ");
            }
            System.out.println();
        }

        System.out.println("pyramid 2");
        for (int line = 1; line <= n; line++) {
            for (int star = 1; star <= n - line + 1; star++) {
                System.out.print("*" + " ");
            }
            System.out.println();
        }

        System.out.println("pyramid 3");
        for (int i = 1; i <= n; i++) {
            // to print space
            for (int j = n; j >= i; j--) {
                System.out.print("  ");
            }
            // to print star
            for (int k = 1; k <= i; k++) {
                System.out.print("*" + " ");
            }
            System.out.println();
        }

        System.out.println("char pyramid ");
        char ch = 'A';
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= i; j++) {
                System.out.print(ch + " ");
                ch++;
            }
            System.out.println();
        }

        System.out.println("char pyramid 2");
        char cha = 'a';
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= i; j++) {
                System.out.print(cha + " ");
                cha++;
            }
            System.out.println();
        }

        System.out.println("number pyramid");
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= n - i + 1; j++) {
                System.out.print(j + " ");
            }
            System.out.println();
        }

        System.out.println("O 1 pyramid");
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= i; j++) {
                if ((i + j) % 2 == 0) {
                    System.out.print("1" + " ");
                } else {
                    System.out.print("0" + " ");
                }
            }
            System.out.println();
        }

        System.out.println("Numbar pyramid");
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= i; j++) {
                System.out.print(i + " ");
            }
            System.out.println();
        }

        System.out.println("Numbar pyramid");
        int count = 1;
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= i; j++) {
                System.out.print(count + "  ");
                count++;
            }
            System.out.println();
        }

        System.out.println("Numbar pyramid");
        for (int i = 1; i <= n; i++) {
            // to print space
            for (int j = n; j >= i; j--) {
                System.out.print(" ");
            }
            // to print star
            for (int k = 1; k <= i; k++) {
                System.out.print(i + " ");
            }
            System.out.println();
        }

        System.out.println("palindrome number pyramid");
        int st = 1;
        int sp = n - 1;
        int lineNo = 1;
        while (lineNo <= n) {
            // to print space
            for (int i = 0; i < sp; i++) {
                System.out.print("  ");
            }
            // to print star => replace with number
            int current = lineNo;
            for (int i = 0; i < st; i++) {
                System.out.print(current + " ");
                if (i < st / 2) {
                    current--;
                } else {
                    current++;
                }
            }
            // prepare for next line
            System.out.println();
            sp--;
            st = st + 2;
            lineNo++;
        }
        System.out.println();

        System.out.println("Enter the row");
        int row = sc.nextInt();
        System.out.println("Enter the col");
        int col = sc.nextInt();

        System.out.println("Solid Rhombus");
        for (int i = 1; i <= n; i++) {
            // to print space
            for (int k = 1; k <= n - i; k++) {
                System.out.print(" ");
            }
            // to print stars
            for (int j = 1; j <= n; j++) {
                System.out.print("*");
            }
            System.out.println();
        }

        System.out.println("hollow Rhombus");
        for (int i = 1; i <= row; i++) {
            for (int j = 1; j <= col; j++) {
                if (i == 1 || j == 1 || i == row || j == col) {
                    System.out.print("*" + " ");
                } else {
                    System.out.print("  ");
                }
            }
            System.out.println();
        }

        System.out.println("hollow tilted Rhombus");
        for (int i = 1; i <= row; i++) {
            // to print space
            for (int k = 1; k <= row - i; k++) {
                System.out.print(" ");
            }
            // to print stars
            for (int j = 1; j <= col; j++) {
                if (i == 1 || j == 1 || i == row || j == col) {
                    System.out.print("* ");
                } else {
                    System.out.print("  ");
                }
            }
            System.out.println();
        }

        System.out.println("Butterfly pattern");
        int star = 1;
        int space = 2 * n - 2;
        int line_no = 1;

        while (line_no <= 2 * n) {
            // print star
            for (int i = 0; i < star; i++) {
                System.out.print("* ");
            }
            // print space
            for (int i = 0; i < space; i++) {
                System.out.print("  ");
            }
            // print star
            for (int i = 0; i < star; i++) {
                System.out.print("* ");
            }
            // prepare for next line
            if (line_no < n) {
                star++;
                space = space - 2;
            } else if (line_no > n) {
                star--;
                space = space + 2;
            }
            System.out.println();
            line_no++;
        }

        System.out.println("Diamond pattern");
        st = 1;
        sp = n - 1;
        lineNo = 1;
        while (lineNo <= 2 * n - 1) {
            // to print space
            for (int i = 0; i < sp; i++) {
                System.out.print("  ");
            }
            // to print star
            for (int i = 0; i < st; i++) {
                System.out.print("* ");
            }
            // prepare for next line
            if (lineNo < n) {
                st = st + 2;
                sp--;
            } else {
                st = st - 2;
                sp++;
            }
            System.out.println();
            lineNo++;
        }
        sc.close();
    }
}
