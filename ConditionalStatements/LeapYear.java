package ConditionalStatements;

import java.util.*;

public class LeapYear {
    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the year : ");
        int year = sc.nextInt();
        sc.close();
        // One way
        if ((year % 4 == 0 && year % 100 != 0) || (year % 4 == 0 && year % 400 == 0)) {
            System.out.println("Year is leap year");
        } else {
            System.out.println("Not a leap Year");
        }
        // Second way
        if (year % 4 == 0) {
            if (year % 100 == 0) {
                if (year % 400 == 0) {
                    System.out.println("Its a leap year ");
                } else {
                    System.out.println("Not a leap year");
                }
            } else {
                System.out.println("Its a leap year");
            }
        } else {
            System.out.println("Not a Leap year");
        }
    }
}
