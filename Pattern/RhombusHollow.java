package Pattern;

import java.util.*;
public class RhombusHollow {
//      * * * * *
//     *       *
//    *       *
//   *       *
//  * * * * *
    public static void main(String args[]){
        Scanner sc = new Scanner(System.in);
        int n=sc.nextInt();
        sc.close();
        int otsp=n-1;
        int line=1;
        int insp=n-2;
        while(line<=n){
            if(line == 1 || line == n){
                //to print outerspace
                for(int i=0;i<otsp;i++){
                    System.out.print(" ");
                }
                //to print star
                for(int i=0;i<n;i++){
                    System.out.print("* ");
                }
            } else{
                 //to print outerspace
                for(int i=0;i<otsp;i++){
                    System.out.print(" ");
                }
                //to print one star
                System.out.print("* ");

                //to print inner space
                for(int i=0;i<insp;i++){
                    System.out.print("  ");
                }
                //to print one star
                System.out.print("* ");
            }
            System.out.println();
            line++;
            otsp--;
        }
    }
}
