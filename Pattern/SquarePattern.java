package Pattern;

import java.util.*;
public class SquarePattern {
    public static void main(String args[])
    {
        int r,c;
        try (Scanner s = new Scanner(System.in)) {
            System.out.println("Enter the number of rows");
            r=s.nextInt();
            System.out.println("Enter the number of column");
            c=s.nextInt();
        }
        for(int i=1;i<=r;i++) {
            for(int j=1;j<=c;j++) {
                System.out.print(" * ");
            }
        System.out.println();
        }
    }
}
