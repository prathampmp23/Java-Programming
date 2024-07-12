import java.util.*;
public class tableFunc {
    public static void Table(int t) {
        for(int i=1;i<=10;i++) {
            System.out.print(t);
            System.out.print(" x ");
            System.out.print( i+" = " );
            System.out.println(t*i);
        }
    }
        public static void main(String args[]) {
            try (Scanner sc = new Scanner(System.in)) {
                System.out.println("Enter the number ");
                int t = sc.nextInt();
                Table(t);
            }
        }
}
