package Pattern;
public class NumbersPyramid {
//         1 
//       2 1 2 
//     3 2 1 2 3 
//   4 3 2 1 2 3 4 
// 5 4 3 2 1 2 3 4 5
    public static void main(String args[]){
        int n=5;
        int st=1;
        int sp=n-1;
        for(int line=1;line<=n;line++){
            //to print space
            for(int i=0;i<sp;i++){
                System.out.print("  ");
            }
            int count =line;
            //to print number
            for(int i=0;i<st;i++){
                System.out.print(count+" ");
                if(i < st/2){
                    count--;
                } else{
                    count++;
                }
            }
            sp--;
            st+=2;
            System.out.println();
        }
    }
}
