package ConditionalStatements;
import java.util.*;
public class incomeTax {
    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        int income;
        int tax;
        System.out.println("Enter the income : ");
        income = sc.nextInt();
        sc.close();
        if(income < 500000) {
            tax = 0;
        }
        else if(income >= 500000 && income < 1000000) {
            tax = (int) (income * 0.2);
        }
        else {
            tax = (int) (income * 0.3);
        }
        System.out.println("The total income tax to be paid : " + tax);
    }
}