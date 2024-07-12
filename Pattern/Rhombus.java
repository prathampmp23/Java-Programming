package Pattern;
public class Rhombus {
//To print Rhombus of Stars
//output
/*       *****
*       *****
*      *****
*     *****
*    *****
*/
    public static void main(String args[]) {
        int n=5;
        for(int i=1;i<=n;i++) {
            //spaces
            for(int j=1;j<=n-i;j++){
                System.out.print(" ");
            }
            //stars
            for(int k=1;k<=5;k++){
                System.out.print("*");
            }
        System.out.println();
        }
    }
}
