package ConditionalStatements;
import java.util.*;
public class Switchcase {
    public static void main(String args[])
    {
        try (Scanner s = new Scanner(System.in)) {
            int choice;
            System.out.println("Enter the choice");
            choice = s.nextInt();

            switch(choice){
                case 1:System.out.println("january");
                break;
                case 2:System.out.println("february");
                break;
                case 3:System.out.println("march");
                break;
                case 4:System.out.println("april");
                break;
                case 5:System.out.println("may");
                break;
                case 6:System.out.println("june");
                break;
                case 7:System.out.println("july");
                break;
                case 8:System.out.println("august");
                break;
                case 9:System.out.println("september");
                break;
                case 10:System.out.println("octomber");
                break;
                case 11:System.out.println("november");
                break;
                case 12:System.out.println("december");
                break;
                default:System.out.println("Not a valid choice");
            }
        }
    }
}
