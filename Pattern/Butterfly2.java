package Pattern;
public class Butterfly2 {
//    *        *
//    **      **
//    ***    ***
//    ****  ****
//    **********
//    **********
//    ****  ****
//    ***    ***
//    **      **
//    *        *
    public static void main(String args[]){
        int n=5;
        int st =1;
        int sp = 2*n-2;
        int line=1;
       
        while(line <= 2*n){
            for(int i=0; i<st; i++){
                System.out.print("*");
            }
            for(int j=0; j<sp; j++){
                System.out.print(" ");
            }
            for(int i=0; i<st; i++){
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
}
