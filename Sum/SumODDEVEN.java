package Sum;
import java.util.*;
public class SumODDEVEN {
    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        int choice;
        int EvenSum = 0;
        int OddSum = 0;
        //When user does not provide at how much time loop can be execute
        //Then we use do..while loop
        do{
            System.out.println("Enter the number :");
            int n = sc.nextInt();
            if(n % 2 ==0){
                EvenSum += n;
            } else {
                OddSum += n;
            }
            System.out.println("Do you want to continue press 1 to continue or 0 to stop : ");
            choice = sc.nextInt();

            if(choice != 1) {
                System.out.println("Enter the choice again ");
                choice = sc.nextInt();
            }
        }while(choice == 1);
        sc.close();
        System.out.println("Sum of Even numbers : " + EvenSum);
        System.out.println("Sum of Odd numbers : " + OddSum);
    }
}