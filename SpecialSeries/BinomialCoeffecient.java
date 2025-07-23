import java.util.*;
public class BinomialCoeffecient {
    public static int Factorial(int n){
        int fact =1;
        for(int i=1;i<=n;i++){
            fact = fact*i;
        }
    return fact;
    }
    // helper function
    public static int BinCoeff(int n, int r){
        int n_fact = Factorial(n);
        int r_fact = Factorial(r);
        int n_r_Fact = Factorial(n-r);

        int BinCoeff = n_fact/(r_fact * n_r_Fact);
        return BinCoeff;
    }

    public static void main(String args[]){
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int r = sc.nextInt();
        sc.close();
        System.out.println("Binomial coefficient of Number = "+BinCoeff(n,r));
    }
}
