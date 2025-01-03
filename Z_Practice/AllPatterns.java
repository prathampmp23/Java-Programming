package Z_Practice;
public class AllPatterns {

    public static void triangle(int n) {
        for (int i = 0; i <= n; i++) {
            for (int j = 0; j < i; j++) {
                System.out.print("*");
            }
            System.out.println();
        }
        System.out.println();
    }

    public static void invertedTriangle(int n) {
        for (int i = n; i > 0; i--) {
            for (int j = 0; j < i; j++) {
                System.out.print("*");
            }
            System.out.println();
        }
        System.out.println();
    }

    public static void halfPyramid(int n) {
        for (int i = 0; i <= n; i++) {
            for (int j = 1; j < i; j++) {
                System.out.print(j);
            }
            System.out.println();
        }
        System.out.println();
    }

    public static void charpattern(int n) {
        char ch = 'A';
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < i; j++) {
                System.out.print(ch);
                ch++;
            }
            System.out.println();
        }
        System.out.println();
    }

    public static void hollowRectangle(int n) {
        for (int i = 0; i < n - 1; i++) {
            for (int j = 0; j < n; j++) {
                if (i == 0 || i == n - 2 || j == 0 || j == n - 1) {
                    System.out.print("*");
                } else {
                    System.out.print(" ");
                }
            }
            System.out.println();
        }
        System.out.println();
    }

    public static void invertedRotatedTriangle(int n) {
        int st = 1;
        int sp = n - 1;
        int line = 1;
        while (line < n) {
            // to print spaces
            for (int i = 0; i < sp; i++) {
                System.out.print(" ");
            }
            // to print stars
            for (int j = 0; j < st; j++) {
                System.out.print("*");
            }
            System.out.println();
            st++;
            sp--;
            line++;
        }
        System.out.println();
    }

    public static void invertednumberPyramid(int n) {
        for (int i = n; i > 0; i--) {
            for (int j = 1; j <= i; j++) {
                System.out.print(j);
            }
            System.out.println();
        }
        System.out.println();
    }

    public static void FLOYDSTriangle(int n) {
        int num = 1;
        for (int i = 0; i <= n; i++) {
            for (int j = 0; j < i; j++) {
                System.out.print(num + " ");
                num++;
            }
            System.out.println();
        }
        System.out.println();
    }

    public static void zeroOneTriangle(int n) {
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= i; j++) {
                if ((i + j) % 2 == 0) {
                    System.out.print("1");
                } else {
                    System.out.print("0");
                }
            }
            System.out.println();
        }
        System.out.println();
    }

    public static void rhombus(int n) {
        int st = n;
        int sp = n - 1;
        int Line = 1;
        while (Line <= n) {
            // to print spaces
            for (int i = 1; i <= sp; i++) {
                System.out.print(" ");
            }
            // to print stars
            for (int j = 1; j <= st; j++) {
                System.out.print("*");
            }
            System.out.println();
            Line++;
            sp--;
        }
        System.out.println();
    }

    public static void hollowRhombus(int n) {
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n - i; j++) {
                System.out.print(" ");
            }
            for (int j = 0; j < n - 1; j++) {
                if (i == 0 || i == n - 1 || j == 0 || j == n - 2) {
                    System.out.print("*");
                } else {
                    System.out.print(" ");
                }
            }
            System.out.println();
        }
        System.out.println();
    }

    public static void numPyramid(int n) {
        int sp = n - 1;
        for (int i = 0; i <= n; i++) {
            // to print spaces
            for (int j = 0; j <= sp; j++) {
                System.out.print(" ");
            }
            // to print numbers
            for (int k = 0; k < i; k++) {
                System.out.print(i + " ");
            }
            System.out.println();
            sp--;
        }
        System.out.println();
    }

    public static void palindromeNumberPyramid(int n) {
        int st = 1;
        int sp = n - 1;
        int lineNo = 1;
        while (lineNo <= n) {
            // to print spaces
            for (int i = 0; i < sp; i++) {
                System.out.print("  ");
            }
            // to print number
            int curr = lineNo;
            for (int i = 0; i < st; i++) {
                System.out.print(curr + " ");
                if (curr > 1) {
                    curr--;
                } else {
                    curr++;
                }
            }
            System.out.println();
            st += 2;
            sp--;
            lineNo++;
        }
        System.out.println();
    }

    public static void butterfly(int n) {
        int st = 1;
        int sp = 2 * n - 2;
        int lineNo = 1;
        while (lineNo <= 2 * n) {
            // To print star
            for (int i = 0; i < st; i++) {
                System.out.print("* ");
            }
            // To print space
            for (int i = 0; i < sp; i++) {
                System.out.print("  ");
            }
            // To print star
            for (int i = 0; i < st; i++) {
                System.out.print("* ");
            }
            if (lineNo < n) {
                st++;
                sp -= 2;
            } else {
                st--;
                sp += 2;
            }
            lineNo++;
            System.out.println();
        }
    }

    public static void diamond(int n) {
        int st = 1;
        int sp = n - 1;
        int lineNo = 1;
        while (lineNo <= 2 * n) {
            // To print space
            for (int i = 0; i < sp; i++) {
                System.out.print("  ");
            }
            // To print star
            for (int i = 0; i < st; i++) {
                System.out.print("$ ");
            }
            if (lineNo < n) {
                sp--;
                st += 2;
            } else {
                sp++;
                st -= 2;
            }
            lineNo++;
            System.out.println();
        }
    }

    public static void main(String[] args) {
        triangle(5);
        invertedTriangle(5);
        halfPyramid(5);
        charpattern(5);
        hollowRectangle(5);
        invertedRotatedTriangle(5);
        invertednumberPyramid(5);
        FLOYDSTriangle(5);
        zeroOneTriangle(5);
        rhombus(5);
        hollowRhombus(5);
        numPyramid(5);
        palindromeNumberPyramid(5);
        butterfly(5);
        diamond(5);
    }
}
