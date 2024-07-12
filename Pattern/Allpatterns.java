package Pattern;
import java.util.*;

public class Allpatterns {

    public static void Rhombus(int n){
        for(int i=1; i<=n; i++){
            //for space
            for(int j=1; j<=n-i; j++){
                System.out.print(" ");
            }//for star
            for(int k=1; k<=n; k++){
                System.out.print("*");
            }
            System.out.println();
        }
    }
    public static void InvertedPyramid(int n){
        for(int i=1; i<=n; i++){
            //for space
            for(int j=1; j<=n-i; j++){
                System.out.print(" ");
            }//for star
            for(int k=1; k<=i; k++){
                System.out.print("*");
            }
            System.out.println();
        }
    }
    public static void InvertedPyramidofNUM(int n){
        for(int i=1; i<=n; i++){
            for(int j=1; j<=n-i+1;j++){
                System.out.print(j+" ");
            }
            System.out.println();
        }
    }
    public static void  FloydsTriangle(int n){
        int count=1;
        for(int i=1; i<=n; i++){
            for(int j=1; j<=i; j++){
                System.out.print(count+" ");
                count++;
            }
            System.out.println();
        }
    }
    public static void ZeroOneTriangle(int n){
        for(int i=1; i<=n; i++){
            for(int j=1; j<=i; j++){
                if((i+j) %2 == 0){
                    System.out.print("1");
                } else {
                    System.out.print("0"); 
                }
            }
            System.out.println();
        }
    }
    public static void Butterfly(int n){
        int st = 1;
        int sp = 2*n-2;
        int line = 1;
        while(line <= 2*n){
            //to print stars
            for(int i=1; i<=st; i++){
                    System.out.print("*");
            }
            //to print space
            for(int j=1; j<=sp; j++){
                    System.out.print(" ");
            }
            //to print stars
            for(int i=1; i<=st; i++){
                    System.out.print("*");
            }
            if(line < n){
                st++;
                sp=sp-2;
            } else if(line > n){
                st--;
                sp=sp+2;
            }
            System.out.println();
            line++;
        }
    }
    public static void Diamond(int n){
        int st=1;
        int sp=n-1;
        int line=1;
        while(line <= 2*n){
            //to print space
            for(int i=1; i<=sp; i++){
                System.out.print(" ");
            }
            //to print star
            for(int j=1; j<=st; j++){
                System.out.print("*");
            }
            if(line < n){
                st=st+2;
                sp--;
            } else if(line > n){
                sp++;
                st=st-2;
            }
            System.out.println();
            line++;
        }
    }
    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        sc.close();
        // Rhombus(n);
        // InvertedPyramid(n);
        // InvertedPyramidofNUM(n);
        // FloydsTriangle(n);
        // ZeroOneTriangle(n);
        // Butterfly(n);
        Diamond(n);
    }
}