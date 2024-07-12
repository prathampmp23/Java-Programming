import java.util.*;
public class circleFun {
    public static void Circumference(double r) {
        double resuslt = 2*3.14*r ;
        System.out.println("Circumference of circle = " +resuslt);
    }
    public static void Area(double r) {
        double area =3.14*r*r;
        System.out.println("Circle area :"+area);
    }
    public static void main(String args[]) {
        double r ;
       Scanner s = new Scanner(System.in);
            System.out.println("Enter the radius ");
            r=s.nextInt();
        s.close();
        Circumference(r);
        Area(r);
    }
}
