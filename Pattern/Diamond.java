package Pattern;
public class Diamond {
//      *
//     ***
//    *****
//   *******
//    *****
//     ***
//      *
    public static void main(String args[]){
        int n=4;
        int sp=n-1;
        int st=1;
        int line;
        for( line =1;line<=2*n-1;line++){
            //to print space
            for(int i=0;i<sp;i++){
                System.out.print(" ");
            }
            //to print star
            for(int i=0;i<st;i++){
                System.out.print("*");
            }
            if(line<n){
                st=st+2;
                sp--;
            } else{
                st=st-2;
                sp++;
            }
            System.out.println();
        }
        }
    }

