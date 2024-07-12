package Pattern;
public class HollowRectangle2 {
// * * * * * 
// *       * 
// *       * 
// * * * * *
    public static void main(String args[]){
        int n=5;
        int st = n;
        int sp = n-2;
        int line = 1;
        while(line<= n - 1){
            if(line == 1 || line == n-1){
                //to print stars
                for(int i=0;i<st;i++){
                System.out.print("* ");
                }
            } else{
                //to print one star
                System.out.print("* ");
                //to print spaces
                for(int j =0;j<sp;j++){
                    System.out.print("  ");
                }
                //to print one star
                System.out.print("* ");
            }
        System.out.println();
        line++;
        }
    }
}
