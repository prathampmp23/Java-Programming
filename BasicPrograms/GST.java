package BasicPrograms;
import java.util.*;
public class GST {
    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the price of Pencil");
        float pencil = sc.nextFloat();
        System.out.println("Enter the price of Pen");
        float pen = sc.nextFloat();
        System.out.println("Enter the price of Eraser");
        float eraser = sc.nextFloat();
        float total = pencil + pen + eraser;
        sc.close();
        System.out.println("Total Bill is : "+ total);
        // Bill with including GSt of 18%
        float newtotal = total + (0.18f * total);
        System.out.println("Total Bill with including 18% GST :" + newtotal);
    }
}
