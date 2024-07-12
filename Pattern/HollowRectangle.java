package Pattern;
import java.util.*;
//To print its Diogonal Element
/*output
 *      ******
 *      *    *
 *      *    *
 *      ******
 */
public class HollowRectangle {
    public static void main(String args[])
    {
        try (Scanner s = new Scanner(System.in)) {
            int r,c;
            System.out.println("Enter the number of rows ");
            r = s.nextInt();
            System.out.println("Enter the number of columns ");
            c = s.nextInt();

            for(int i=1;i<=r;i++)
            {
                for(int j=1;j<=c;j++)
                {
                    if(i==1 || j==1 || i==r || j==c) {
                        System.out.print("*");
                    }
                    else {
                        System.out.print(" ");
                    }
                }
            System.out.println();
            }
        }
    }
}