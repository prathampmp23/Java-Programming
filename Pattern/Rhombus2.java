package Pattern;
public class Rhombus2 {
//     ******    
//    ******   
//   ******  
//  ****** 
// ******

    public static void main(String args[]) {
        int n=5;
        int st=n;
        int sp=n-1;
        int line =1;
        while(line<=n){
            //to print space
            for(int i=0;i<sp;i++){
                System.out.print(" ");
            }
            //to print star
            for(int i=0;i<=st;i++){
                System.out.print("*");
            }
            //to print space
            for(int i=0;i<sp;i++){
                System.out.print(" ");
            }
            sp--;
            line++;
            System.out.println();
        }
    }
}