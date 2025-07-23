import java.util.*;

//Program to find Greatest common divisor
public class GCDandLCM {
    public static int gcd(int a, int b) {
        if (b == 0)
            return a;
        return gcd(b, a % b);
    }

    public static int lcm(int a, int b) {
        return (a * b) / gcd(a, b);
    }

    public static void main(String args[]) {
        Scanner s = new Scanner(System.in);
        System.out.println("Enter the two number");
        int a = s.nextInt();
        int b = s.nextInt();
        int gcd = 1;
        s.close();
        for (int i = 1; i <= a && i <= b; i++) {
            if (a % i == 0 && b % i == 0)
                gcd = i;
        }
        System.out.println("Greatest common divisor : " + gcd);

        int gcdVal = gcd(a, b);
        int lcmVal = lcm(a, b);

        System.out.println("Greatest common divisor(GCD) of " + a + " and " + b + " is: " + gcdVal);
        System.out.println("Least Common Multiple(LCM) of " + a + " and " + b + " is: " + lcmVal);
    }
}