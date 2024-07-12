package Pattern;
public class practice1 {
    public static void main(String args[]) {
        // int n=5;
        // for(int i=1;i<=n;i++){
        //     for(int j=1;j<=i;j++){
        //         System.out.print(" * ");
        //     }
        // System.out.println();
        // }
        // System.out.println();

        // Alternate way
        // int n = 5;
        // int st = 1;
        // int sp = n - 1;
        // int line = 0;
        // while(line<= n){
        //     for(int i=0;i<st;i++){
        //         System.out.print(" * ");
        //     }
        //     for(int j=0;j<sp;j++){
        //         System.out.print(" ");
        //     }
        // System.out.println();
        // st++;
        // sp--;
        // line++;
        // }

        // int n = 5;
        // int st = n-1;
        // int sp = 1;
        // int line = 1;
        // while(line<= n){
        //     for(int i=0;i<st;i++){
        //         System.out.print(" * ");
        //     }
        //     for(int j=0;j<sp;j++){
        //         System.out.print(" ");
        //     }
        // System.out.println();
        // st--;
        // sp++;
        // line++;
        // }
        
        // int n = 5;
        // int st = 1;
        // int sp = n - 1;
        // int line = 1;
        // while(line <= n){
        //     for(int j=0;j<sp;j++){
        //         System.out.print(" ");
        //     }
        //     for(int i=0;i<st;i++){
        //         System.out.print("*");
        //     }
        // System.out.println();
        // st++;
        // sp--;
        // line++;
        // }
        
        // int n=5;
        // int st=n;
        // int sp=1;
        // int line = 1;
        // while (line<=n) {
        //     //to print stars
        //     for(int i=0;i<st;i++){
        //         System.out.print("* ");
        //     }
        //     //to print space
        //     for(int j=0;j<sp;j++){
        //         System.out.print(" ");
        //     }
        //     System.out.println();
        //     st--;
        //     sp++;
        //     line++;
        // }

        // int n=5;
        // int st=1;
        // int sp=n-1;
        // int line = 1;
        // while (line<=n) {
        //     //to print spaces
        //     for(int i=0;i<sp;i++){
        //         System.out.print(" ");
        //     }
        //     //to print star
        //     for(int j =0;j<st;j++){
        //         System.out.print("*");
        //     }
        //     System.out.println();
        //     st++;
        //     sp--;
        //     line++;
        // }

        int n=5;
        int st= n;
        int sp= n-2;
        int line = 1;
        while (line<= n - 1) {
            //to print star
            if(line == 1 || line ==n-1){
                for(int i=1;i<st;i++){
                    System.out.print("* ");
                }
            } else {
                //to print one star
                System.out.print("* ");
                //to print spaces
                for(int j =1;j<sp;j++){
                    System.out.print("  ");
                }
                //to print one star
                System.out.print("* ");
            }
            line++;
            System.out.println();

    }
}
}