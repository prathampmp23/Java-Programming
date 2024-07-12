package Pattern;
public class numbersPattern {
// 1 
// 2 3 
// 4 5 6 
// 7 8 9 10 
// 11 12 13 14 15 

// 12345
// 1234
// 123
// 12
// 1

    public static void main(String args[]){
        int n =5;
        int num =1;
        for(int i =1;i<=n;i++){
            for(int j=1;j<=i;j++){
                System.out.print(num+" ");
                num++;
            }
        System.out.println();
        }

        System.out.println();

        int m=5;
        for(int i=m;i>=1;i--) {
            for(int j=1;j<=i;j++) {
                System.out.print(j);
            }
        System.out.println();
        }
    }
}
