package Pattern;
public class Butterfly {
    //Program to print Butterfly Pattern
    public static void main(String args[]) {
        int n = 4;
        //for upper part
        for(int i=1;i<=n;i++) {
            //first part
            for(int j=1;j<=i;j++){
                System.out.print("*");
            }
            //for space
            int spaces =2*(n-i);
            for(int j=1;j<=spaces;j++){
                System.out.print(" ");
            }
            //second part
            for(int j=1;j<=i;j++){
                System.out.print("*");
            }
        System.out.println();
        }
        for(int i=n;i>=1;i--) {
            //first part
            for(int j=1;j<=i;j++){
                System.out.print("*");
            }
            //for space
            int spaces =2*(n-i);
            for(int j=1;j<=spaces;j++){
                System.out.print(" ");
            }
            //second part
            for(int j=1;j<=i;j++){
                System.out.print("*");
            }
        System.out.println();
        }
    }
}
