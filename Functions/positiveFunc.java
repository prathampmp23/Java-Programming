import java.util.*;
public class positiveFunc {

    public static void testPositive(int n) {
        System.out.println(" Is positive");
    }
    public static void main(String args[]) {
        try (Scanner sc = new Scanner(System.in)) {
            int n = sc.nextInt();
            if(n>0) {
                testPositive(n);
            }
            else {
                System.out.println("It is not positive ");
            }
        }
    }
}
