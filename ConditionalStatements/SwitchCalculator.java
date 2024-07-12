package ConditionalStatements;
import java.util.*;
 class SwitchCalculator {
    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        int a , b;
        System.out.println("Enter the value of a :");
        a=sc.nextInt();
        System.out.println("Enter the value of b :");
        b=sc.nextInt();
        System.out.println("Enter + this for Addition");
        System.out.println("Enter - this for Subtraction");
        System.out.println("Enter * this for Multiplication");
        System.out.println("Enter / this for Division");
        System.out.println("Ente the operator : ");
        char operator = sc.next().charAt(0);
        sc.close();
        switch(operator) {
            case '+': System.out.println(a+b);
            break;
            case '-': System.out.println(a-b);
            break;
            case '*': System.out.println(a*b);
            break;
            case '/': System.out.println(a/b);
            break;
            default : System.out.println("Wrong operator is chosen ");
        }
    }
}