package Arrays2D;

public class matrix1 {
    public static void main(String args[]) {
        int a[]={1,2,3,5,6,7};
        System.out.println(a[2]);
        int b[][]={{1,2,3},{1,2,3},{1,2,3}};
        for(int i=0;i<3;i++) {
            for(int j=0;j<3;j++) {
                System.out.print( b[i][j] +" ");
            }
        System.out.println();
        }
    }
}