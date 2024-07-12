import java.util.*;

public class Practice {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the number :");
        int n = sc.nextInt();
        for (int line = 1; line <= n; line++) {
            for (int star = 1; star <= line; star++) {
                System.out.print("*" + " ");
            }
            System.out.println();
        }
        System.out.println();
        for (int line = 1; line <= n; line++) {
            for (int star = n; star >= line; star--) {
                System.out.print("*" + " ");
            }
            System.out.println();
        }
        System.out.println();
        for (int line = 1; line <= n; line++) {
            for (int star = 1; star <= n - line + 1; star++) {
                System.out.print("*" + " ");
            }
            System.out.println();
        }
        System.out.println();
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= i; j++) {
                System.out.print(i + " ");
            }
            System.out.println();
        }
        System.out.println();
        int count = 1;
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= i; j++) {
                System.out.print(count + "  ");
                count++;
            }
            System.out.println();
        }
        System.out.println();
        char ch = 'A';
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= i; j++) {
                System.out.print(ch + " ");
                ch++;
            }
            System.out.println();
        }
        System.out.println();
        char cha = 'a';
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= i; j++) {
                System.out.print(cha + " ");
                cha++;
            }
            System.out.println();
        }
        System.out.println();

        System.out.println("Enter the row");
        int row = sc.nextInt();
        System.out.println("Enter the col");
        int col = sc.nextInt();
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
        System.out.println();
        for (int i = 1; i <= n; i++) {
            // to print space
            for (int j = n; j >= i; j--) {
                System.out.print("  ");
            }
            // to print star
            for (int k = 1; k <= i; k++) {
                System.out.print("*"+" ");
            }
            System.out.println();
        }
        System.out.println();
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
        System.out.println();
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= n - i + 1; j++) {
                System.out.print(j + " ");
            }
            System.out.println();
        }
        System.out.println();
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
        System.out.println();
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
        System.out.println();
        for (int i = 1; i <= row; i++) {
            // to print space
            for (int k = 1; k <= row - i; k++) {
                System.out.print(" ");
            }
            // to print stars
            for (int j = 1; j <= col; j++) {
                if (i == 1 || j == 1 || i == row || j == col) {
                    System.out.print("*");
                } else {
                    System.out.print(" ");
                }
            }
            System.out.println();
        }
        System.out.println();

        for (int i = 1; i <= n; i++) {
            // to print space
            for (int k = 1; k <= n - i + 1; k++) {
                System.out.print(" ");
            }
            // to print star
            for (int j = 1; j <= i; j++) {
                System.out.print("*" + " ");
            }
            System.out.println();
        }
        for (int i = 1; i <= n; i++) {
            // to print sapace
            for (int k = 1; k <= i; k++) {
                System.out.print(" ");
            }
            // to print star
            for (int j = 1; j <= n - i + 1; j++) {
                System.out.print("*" + " ");
            }
            System.out.println();
        }
        System.out.println();

        for(int i=1; i<=n; i++) {
            //to print star
            for(int j=1; j<=i; j++) {
                System.out.print("*"+" ");
            }
            //to print sapce
            for(int k=1; k <= 2*(n-i); k++){
                System.out.print("  ");
            }
            //to print star
            for(int l=1; l<=i; l++) {
                System.out.print("*"+" ");
            }
            System.out.println();
        }
        for(int i=n; i>=1; i--) {
            //to print star
            for(int j=1; j<=i; j++) {
                System.out.print("*"+" ");
            }
            //to print sapce
            for(int k=1; k <= 2*(n-i); k++){
                System.out.print("  ");
            }
            //to print star
            for(int j=1; j<=i; j++) {
                System.out.print("*"+" ");
            }
            System.out.println();
        }
        
        sc.close();
    }
}
