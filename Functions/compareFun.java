import java.util.*;
public class compareFun {
    public static void Comparision(int a , int b) {
        if(a > b) {
            System.out.println("Greater number is " +a);
        }else {
            System.out.println("Greater number is " +b);
        }
    }
    public static void main(String args[]) {
        int a ,b ;
        try (Scanner s = new Scanner(System.in)) {
            System.out.println("Enter the two number to compare");
            a = s.nextInt();
            b = s.nextInt();
        }
        Comparision(a,b);
    }
}