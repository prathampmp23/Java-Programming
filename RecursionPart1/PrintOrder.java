public class PrintOrder {
    public static void printDec(int n) {
        // to print numbers in Decreasing order
        // Base condition
        if (n == 1) {
            System.out.print(n);
            return;
        }
        // to print given n
        System.out.print(n + " ");
        // to do work from inner function
        printDec(n - 1);
    }

    public static void printInc(int n) {
        // to print numbers in increasing order
        // Base condition
        if (n == 1) {
            System.out.print(n + " ");
            return;
        }
        // to do work from inner function
        printInc(n - 1);
        // to print given n
        System.out.print(n + " ");
    }

    public static void main(String args[]) {
        int n = 10;
        // to print numbers is reverse(decreasing) order
        printInc(n);
    }
}
