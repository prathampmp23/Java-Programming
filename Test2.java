public class Test2 {

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
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                
            }
        }
    }

    public static void main(String[] args) {
        triangle(5);
        invertedTriangle(5);
        halfPyramid(5);
        charpattern(5);
        hollowRectangle(5);
        invertedRotatedTriangle(5);
    }
}
